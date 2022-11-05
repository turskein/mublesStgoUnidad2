package tingeso.salaries.services.salary;

import tingeso.salaries.entities.CategoryEntity;
import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.services.salary.discounts.ApplyDscts;
import tingeso.salaries.services.salary.discounts.Cotizations;
import tingeso.salaries.services.salary.extraSalary.Bonifications;
import tingeso.salaries.services.salary.extraSalary.ExtraHours;
import tingeso.salaries.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSalaryByOneStaff {

    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    SalaryByCategory salaryByCategory;

    @Autowired
    ApplyDscts applyDscts;

    @Autowired
    Bonifications bonifications;

    @Autowired
    ExtraHours extraHours;

    @Autowired
    Cotizations cotizations;

    private CategoryEntity getCategory(StaffEntity worker){
        long idCategory = worker.getIdCategory();
        return categoryRepository.findAllById(idCategory).get(0);
    }

    private int positiveSalary(int salary){
        if(salary > 0){
            return salary;
        }
        return 0;
    }

    public int getFixedSalary(CategoryEntity category){
        return salaryByCategory.getSalaryByCategory(category);
    }

    public int getRawSalary(StaffEntity worker, int month, int year){
        CategoryEntity category = getCategory(worker);
        int salaryForWorker = getFixedSalary(category);
        int discounts = applyDscts.applyDiscount(salaryForWorker,worker,month,year);
        int salaryBonifications = bonifications.getBonifications(salaryForWorker,worker);
        int salaryForExtraHours = extraHours.salaryExtraHours(worker,category,month,year);

        int rawSalary = salaryForWorker+salaryBonifications+salaryForExtraHours-discounts;
        return positiveSalary(rawSalary);
    }
    public int getRealSalary(StaffEntity worker, int month, int year){
        int rawSalary = getRawSalary(worker, month, year);
        int cotizationsDiscounts = cotizations.getPrevisionalSalary(rawSalary);
        cotizationsDiscounts = cotizationsDiscounts + cotizations.getPrevisionalSalud(rawSalary);
        return positiveSalary(rawSalary - cotizationsDiscounts);
    }

}

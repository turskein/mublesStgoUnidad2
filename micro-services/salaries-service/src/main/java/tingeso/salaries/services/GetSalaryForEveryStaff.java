package tingeso.salaries.services;

import tingeso.salaries.entities.CategoryEntity;
import tingeso.salaries.models.SalaryModel;
import lombok.*;
import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.repositories.CategoryRepository;
import tingeso.salaries.repositories.StaffRepository;
import tingeso.salaries.services.salary.GetSalaryByOneStaff;
import tingeso.salaries.services.salary.discounts.ApplyDscts;
import tingeso.salaries.services.salary.discounts.Cotizations;
import tingeso.salaries.services.salary.extraSalary.Bonifications;
import tingeso.salaries.services.salary.extraSalary.ExtraHours;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSalaryForEveryStaff {

        @Autowired
        CategoryRepository categoryRepository;
        @Autowired
        GetSalaryByOneStaff getSalaryByOneStaff;
        @Autowired
        Bonifications bonifications;

        @Autowired
        Cotizations cotizations;

        @Autowired
        ExtraHours extraHours;

        @Autowired
        ApplyDscts applyDscts;

        @Autowired
        StaffRepository staffRepository;

        @Generated
        public CategoryEntity getCategory(StaffEntity worker) {
                long idCategory = worker.getIdCategory();
                return categoryRepository.findAllById(idCategory).get(0);
        }

        public List<SalaryModel> getSalaryForEveryStaff(int monnth, int year) {
                List<StaffEntity> staffEntities = (List<StaffEntity>) staffRepository.findAll();
                List<SalaryModel> everySalary = new ArrayList<>();
                for (int i = 0; i < staffEntities.size(); i++) {
                        SalaryModel currentSalary = new SalaryModel();
                        StaffEntity currentWorker = staffEntities.get(i);
                        CategoryEntity currentCategory = getCategory(currentWorker);

                        currentSalary.setName(currentWorker.getName());
                        currentSalary.setLastName(currentWorker.getLastname());
                        currentSalary.setRut(currentWorker.getRut());
                        currentSalary.setCategory(currentSalary.getCategory());

                        int serviceYears = bonifications.serviceYears(currentWorker);
                        currentSalary.setServiceYears(serviceYears);
                        int fixedSalary = getSalaryByOneStaff.getFixedSalary(currentCategory);

                        currentSalary.setFixedSalary(fixedSalary);
                        int bonificationSalary = bonifications
                                        .getBonifications(
                                                        fixedSalary,
                                                        currentWorker);
                        currentSalary.setBonificationsSalary(bonificationSalary);
                        int extraHoursSalary = extraHours
                                        .salaryExtraHours(
                                                        currentWorker,
                                                        currentCategory,
                                                        monnth,
                                                        year);
                        currentSalary.setExtraHoursSalary(extraHoursSalary);
                        int discountSalary = applyDscts
                                        .applyDiscount(
                                                        fixedSalary,
                                                        currentWorker,
                                                        monnth,
                                                        year);
                        currentSalary.setDiscountsSalary(discountSalary);

                        int rawSalary = getSalaryByOneStaff.getRawSalary(
                                        currentWorker,
                                        monnth,
                                        year);
                        currentSalary.setRawSalary(rawSalary);

                        int previsionalSalary = cotizations.getPrevisionalSalary(rawSalary);
                        currentSalary.setPrevisionalSalary(previsionalSalary);
                        int healthSalary = cotizations.getPrevisionalSalud(rawSalary);
                        currentSalary.setHealthSalary(healthSalary);
                        int realSalary = getSalaryByOneStaff
                                        .getRealSalary(
                                                        currentWorker,
                                                        monnth,
                                                        year);
                        currentSalary.setRealSsalary(realSalary);

                        everySalary.add(currentSalary);
                }
                return everySalary;
        }
}

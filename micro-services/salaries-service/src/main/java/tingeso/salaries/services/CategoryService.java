package tingeso.salaries.services;

import tingeso.salaries.entities.CategoryEntity;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public boolean isCategoryA(CategoryEntity category){
        return category.getCategory().equals("A");
    }
    public boolean isCategoryB(CategoryEntity category){
        return category.getCategory().equals("B");
    }

    public boolean isCategoryC(CategoryEntity category){
        return category.getCategory().equals("C");
    }

}

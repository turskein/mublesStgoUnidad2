package tingeso.salaries.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class SalaryModel {
    String rut;
    String name;
    String lastName;
    String category;
    int serviceYears;
    int bonificationsSalary;
    int fixedSalary;
    int extraHoursSalary;
    int discountsSalary;
    int rawSalary;
    int previsionalSalary;
    int healthSalary;
    int realSsalary;
}

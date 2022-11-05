package tingeso.salaries.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraHoursModel {
    private Long idExtraHours;
    private Long idStaff;
    private Date date;
    private int amount;
}

package tingeso.salaries.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimestampModel {
    private Long idTimestamp;
    private Long idStaff;
    private Time time;
    private Date date;
}

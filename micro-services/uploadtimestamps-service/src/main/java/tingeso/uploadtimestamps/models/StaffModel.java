package tingeso.uploadtimestamps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffModel {
    private Long idStaff;
    private String rut;
    private String lastname;
    private String name;
    private Date birthday;
    private Long idCategory;
    private Date ingress;
}

package tingeso.uploadjustification.service;

import tingeso.uploadjustification.entities.JustificationEntity;
import tingeso.uploadjustification.repositories.JustificationRepository;
import tingeso.uploadjustification.models.StaffModel;
import lombok.Generated;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

@Service
public class UploadJustificationService {

    @Autowired
    private JustificationRepository justificationRepository;

    @Autowired
    RestTemplate restTemplate;

    @Generated
    public Long getIdByRut(String rut){
        ResponseEntity<StaffModel> response = restTemplate.getForEntity("http://salaries-service/staff/byrut?rut=" + rut, StaffModel.class);
        if(response.getBody() == null){
            System.out.println("Status code, esto sucede porque el body es null, es decir, no encuentra el staff: "+response.getStatusCode());
            return null;
        }
        StaffModel staff = response.getBody();
        return staff.getIdStaff();
    }

    @Generated
    private int saveJustification(Long id, JustificationEntity justificationEntity){
        justificationEntity.setIdStaff(id);
        try{
            justificationRepository.save(justificationEntity);
            return 0;
        }catch (Exception e){
            return 1;
        }
    }

    public int uploadJustifive(String rut, Date date){
        JustificationEntity justificationEntity = new JustificationEntity();
        justificationEntity.setDate(date);
        Long idStaff = getIdByRut(rut);
        if(idStaff == Integer.toUnsignedLong(0)){
            return 1;
        }
        if(saveJustification(idStaff, justificationEntity) == 1){
            return 1;
        }
        return 0;
    }
}

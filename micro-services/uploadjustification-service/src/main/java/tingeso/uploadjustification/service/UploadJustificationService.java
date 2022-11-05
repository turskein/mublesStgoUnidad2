package tingeso.uploadjustification.service;

import tingeso.uploadjustification.entities.JustificationEntity;
import tingeso.uploadjustification.repositories.JustificationRepository;
import tingeso.uploadjustification.models.StaffModel;
import lombok.Generated;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class UploadJustificationService {

    @Autowired
    private JustificationRepository justificationRepository;

    @Autowired
    RestTemplate restTemplate;

    @Generated
    private Long getIdByRut(String rut){
        try {
            List<StaffModel> finded = restTemplate.getForObject("http://salaries-service/salaries/staff-byrut/" + rut, List.class);
            if(finded == null){
                return null;
            }
            return finded.get(0).getIdStaff();
        }catch (Exception e){
            return Integer.toUnsignedLong(0);
        }
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

package tingeso.uploadextrahours.services;


import tingeso.uploadextrahours.entities.ExtraHoursEntity;
import tingeso.uploadextrahours.repositories.ExtraHoursRepository;
import tingeso.uploadextrahours.models.StaffModel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Generated;

import java.util.Date;
import java.util.List;

@Service
public class UploadExtraHoursService {

    @Autowired
    ExtraHoursRepository extraHoursRepository;

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

    private void saveJustification(Long id, ExtraHoursEntity extraHoursEntity){
        extraHoursEntity.setIdStaff(id);
        extraHoursRepository.save(extraHoursEntity);
    }

    public int uploadExtraHours(String rut, Date date, int amount){
        ExtraHoursEntity extraHoursEntity = new ExtraHoursEntity();
        extraHoursEntity.setAmount(amount);
        extraHoursEntity.setDate(date);
        Long idStaff = getIdByRut(rut);
        if(idStaff == Integer.toUnsignedLong(0)){
            return 1;
        }
        saveJustification(idStaff, extraHoursEntity);
        return 0;
    }

}

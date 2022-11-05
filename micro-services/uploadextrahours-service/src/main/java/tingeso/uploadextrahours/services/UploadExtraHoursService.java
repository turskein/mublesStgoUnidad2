package tingeso.uploadextrahours.services;


import tingeso.uploadextrahours.entities.ExtraHoursEntity;
import tingeso.uploadextrahours.repositories.ExtraHoursRepository;
import tingeso.uploadextrahours.models.StaffModel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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

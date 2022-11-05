package tingeso.uploadjustification.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tingeso.uploadjustification.repositories.JustificationRepository;
import tingeso.uploadjustification.entities.JustificationEntity;

@Service
public class JustificationService {
    
    @Autowired
    JustificationRepository justificationRepository;

    public List<JustificationEntity> findByIdStaffAndDate(Long idStaff, Date date){
        return justificationRepository.findByIdStaffAndDate(idStaff, date);
    }

}

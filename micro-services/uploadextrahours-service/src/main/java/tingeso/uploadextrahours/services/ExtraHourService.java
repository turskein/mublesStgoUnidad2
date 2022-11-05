package tingeso.uploadextrahours.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tingeso.uploadextrahours.entities.ExtraHoursEntity;
import tingeso.uploadextrahours.repositories.ExtraHoursRepository;

@Service
public class ExtraHourService {
    @Autowired
    ExtraHoursRepository extraHoursRepository;

    public List<ExtraHoursEntity> findAllByIdStaffAndMonthAndYear(Long idStaff, int month, int year){
        return extraHoursRepository.findAllByIdStaffAndMonthAndYear(idStaff, month, year);
    }
}

package tingeso.uploadtimestamps.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tingeso.uploadtimestamps.entities.TimestampEntity;
import tingeso.uploadtimestamps.repositories.TimestampRepository;

@Service
public class TimestampsService {

    @Autowired
    TimestampRepository timestampRepository;

    public List<TimestampEntity> findByIdStaffAndDate(Long idStaff, Date date){
        return timestampRepository.findByIdStaffAndDate(idStaff, date);
    }

}

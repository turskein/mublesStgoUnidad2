package tingeso.uploadtimestamps.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("yyyy/MM/dd");

    public List<TimestampEntity> findByIdStaffAndDate(Long idStaff, int year, int month, int day){
        try{
            return timestampRepository.findByIdStaffAndDate(idStaff, simpleDateFormatForDate.parse(year+"/"+month+"/"+day));
        }catch(ParseException e){
            System.out.println(e);
            return null;
        }
        
    }

}

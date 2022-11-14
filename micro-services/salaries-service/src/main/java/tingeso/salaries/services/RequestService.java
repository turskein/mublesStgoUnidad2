package tingeso.salaries.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.bouncycastle.asn1.x509.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import tingeso.salaries.models.ExtraHoursModel;
import tingeso.salaries.models.TimestampModel;

@Service
public class RequestService {
    @Autowired
    RestTemplate restTemplate;

    public List<TimestampModel> timestampsGetByIdStaffAndDate(Long IdStaff, Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        String resourceUrl = "http://uploadtimestamps-service/timestamps/"+IdStaff+"?year="+year+"&month="+month+"&day="+day;
        ResponseEntity<Object[]> response = restTemplate.getForEntity(resourceUrl,Object[].class);
        if(response == null){
            return null;
        }
        Object[] records = response.getBody();

        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return Arrays.stream(records)
                .map(employee -> mapper.convertValue(employee, TimestampModel.class))
                .collect(Collectors.toList());
    }

    public List<ExtraHoursModel> extraHoursfindAllByIdStaffAndMonthAndYear(Long idStaff, int month, int year){
        String query = "http://uploadextrahours-service/extrahours/"+idStaff+"/"+month+"/"+year;
        ResponseEntity<Object[]> response = restTemplate.getForEntity(query, Object[].class);
        if(response == null){
            return null;
        }
        Object[] records = response.getBody();

        ObjectMapper mapper = new ObjectMapper(); // Mapper desde object a modelo Empleado
        return Arrays.stream(records)
                .map(employee -> mapper.convertValue(employee, ExtraHoursModel.class))
                .collect(Collectors.toList());
    }
}

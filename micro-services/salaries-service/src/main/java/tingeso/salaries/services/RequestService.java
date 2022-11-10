package tingeso.salaries.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        String resourceUrl = "http://uploadtimestamps-service/timestamps/"+IdStaff+"?year="+year+"&month="+month+"&day="+day;
        System.out.println(resourceUrl);
        ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl,List.class);
        if(response == null){
            System.out.println("wea mala");
            return null;
        }
        return response.getBody();
    }

    public List<ExtraHoursModel> extraHoursfindAllByIdStaffAndMonthAndYear(Long idStaff, int month, int year){
        RestTemplate restTemplate = new RestTemplate();
        String query = "http://uploadextrahours-service/extrahours/"+idStaff+"/"+month+"/"+year;
        ResponseEntity<List> response = restTemplate.getForEntity(query, List.class);
        if(response == null){
            return null;
        }
        List<ExtraHoursModel> extraHours = response.getBody();
        return extraHours;
    }
}

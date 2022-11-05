package tingeso.salaries.services;

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

    public List<TimestampModel> timestampsGetByIdStaffAndDate(Long IdStaff, Date date){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://uploadtimestamps-service/timestamps/"+IdStaff;
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("date",date.toString());

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List> response = restTemplate.exchange(
            resourceUrl,
            HttpMethod.GET,
            request,
            List.class);
        return response.getBody();
    }

    public List<ExtraHoursModel> extraHoursfindAllByIdStaffAndMonthAndYear(Long idStaff, int month, int year){
        RestTemplate restTemplate = new RestTemplate();
        String query = "http://uploadextrahours-service/extrahours/"+idStaff+"/"+month+"/"+year;
        List<ExtraHoursModel> extraHours = restTemplate.getForObject(query, List.class);
        return extraHours;
    }
}

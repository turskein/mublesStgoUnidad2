package tingeso.uploadextrahours.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Generated;
import tingeso.uploadextrahours.entities.ExtraHoursEntity;
import tingeso.uploadextrahours.services.ExtraHourService;

@Controller
@RestController
@RequestMapping("/extrahours")
@Generated
public class ExtraHoursController {
    @Autowired
    ExtraHourService extraHourService;

    @GetMapping("/{id}/{month}/{year}")
    public ResponseEntity<List<ExtraHoursEntity>> findByIdStaffAndDate(@PathVariable("id") Long idStaff,@PathVariable("month")int month,@PathVariable("year") int year ){
        return ResponseEntity.ok(extraHourService.findAllByIdStaffAndMonthAndYear(idStaff,month,year));
    }
}

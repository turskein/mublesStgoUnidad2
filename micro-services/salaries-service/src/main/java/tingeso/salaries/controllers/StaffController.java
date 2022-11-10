package tingeso.salaries.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import lombok.Generated;
import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.models.TimestampModel;
import tingeso.salaries.services.RequestService;
import tingeso.salaries.services.StaffService;

@RestController
@RequestMapping("/staff")
@Generated
public class StaffController {
    @Autowired
    StaffService staffService;

    @Autowired
    RequestService requestService;

    //Funcionandiing
    @GetMapping("/byrut")
    public ResponseEntity<StaffEntity> findStaffByRut(@RequestParam String rut){
        StaffEntity response = staffService.findStaffByRut(rut);
        if(response == null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(response);
    }

    // Funcionandiing
    @GetMapping("/consulta")
    public ResponseEntity<List<TimestampModel>> lala(@RequestParam Long IdStaff, @RequestParam Date date ){
        return ResponseEntity.ok(requestService.timestampsGetByIdStaffAndDate(IdStaff,date));
    }
}

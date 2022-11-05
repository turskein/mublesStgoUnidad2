package tingeso.salaries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import lombok.Generated;
import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.services.StaffService;

@Controller
@RestController
@RequestMapping("/staff")
@Generated
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("/byrut")
    public ResponseEntity<StaffEntity> findStaffByRut(@RequestParam String rut){
        StaffEntity response = staffService.findStaffByRut(rut);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }


}

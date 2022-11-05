package tingeso.uploadjustification.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Generated;
import tingeso.uploadjustification.entities.JustificationEntity;
import tingeso.uploadjustification.service.JustificationService;

@Controller
@RestController
@RequestMapping("/justification")
@Generated
public class JustificationController {

    @Autowired
    JustificationService justificationService;

    @GetMapping("/{id}")
    public ResponseEntity<List<JustificationEntity>> findByIdStaffAndDate(@PathVariable("id") Long idStaff,@RequestBody Date date){
        return ResponseEntity.ok(justificationService.findByIdStaffAndDate(idStaff, date));
    }
}

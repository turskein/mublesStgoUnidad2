package tingeso.uploadjustification.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Generated;
import tingeso.uploadjustification.service.UploadJustificationService;

@Controller
@RestController
@RequestMapping("/uploadjustification")
@Generated
public class UploadJustificationController {
    @Autowired
    UploadJustificationService uploadJustificationService;

    @PostMapping("/upload-justification")
    public ResponseEntity<Integer> uploadJustifyBackwardness(@RequestParam(value="rut") String rut,
                                         @RequestParam(value="date") Date date
                                         ){
    int response = uploadJustificationService.uploadJustifive(rut,date);
    if(response != 0){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(response);
    }
}

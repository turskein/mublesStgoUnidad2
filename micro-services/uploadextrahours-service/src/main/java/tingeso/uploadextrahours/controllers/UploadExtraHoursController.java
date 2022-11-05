package tingeso.uploadextrahours.controllers;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.bouncycastle.asn1.ocsp.ResponderID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Generated;
import tingeso.uploadextrahours.services.UploadExtraHoursService;

@Controller
@RestController
@RequestMapping("/uploadjustification")
@Generated
public class UploadExtraHoursController {
    @Autowired
    UploadExtraHoursService uploadExtraHoursService;

    @PostMapping()
    public ResponseEntity<Integer> uploadJustifyExtraHours(@RequestParam(value="rut") String rut,
                                        @RequestParam(value="date") Date date,
                                        @RequestParam(value = "amount") int amount
                                        ){
    int response = uploadExtraHoursService.uploadExtraHours(rut,date,amount);
    if(response != 0){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(response);
    }
}

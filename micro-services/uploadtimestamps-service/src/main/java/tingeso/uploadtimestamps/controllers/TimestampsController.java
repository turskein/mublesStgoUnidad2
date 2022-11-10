package tingeso.uploadtimestamps.controllers;

import lombok.Generated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import tingeso.uploadtimestamps.entities.TimestampEntity;
import tingeso.uploadtimestamps.services.TimestampsService;

@Controller
@RestController
@RequestMapping("/timestamps")
@Generated
public class TimestampsController {
    @Autowired
    TimestampsService timestampsService;

    @GetMapping("/{id}")
    public ResponseEntity<List<TimestampEntity>> findByIdStaffAndDate(@PathVariable("id") Long idStaff,
    @RequestParam int year, @RequestParam int month,
    @RequestParam int day){
        List<TimestampEntity> response = timestampsService.findByIdStaffAndDate(idStaff, year, month, day);
        return ResponseEntity.ok(response);
    }
}

package tingeso.uploadtimestamps.controllers;

import lombok.Generated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tingeso.uploadtimestamps.services.TimestampsService;
import tingeso.uploadtimestamps.services.UploadTimestampsService;

@Controller
@RestController
@RequestMapping("/uploadtimestamps")
@Generated
public class UploadTimestampsController {
    @Autowired
    UploadTimestampsService uploadTimestampsService;

    @Autowired
    TimestampsService timestampsService;

    /*
     * If was correctly executed return is 0, antoher number otherwise
     */
    @PostMapping("/upload-timestamps")
    public ResponseEntity<Integer> uploadTimestamps(@RequestParam("file") MultipartFile file){
        int response = uploadTimestampsService.uploadTimestamps(file);
        if(response != 0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }
}

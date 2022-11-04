package tingeso.uploadtimestamps.controllers;

import lombok.Generated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tingeso.uploadtimestamps.entities.TimestampEntity;
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

    @PostMapping("/upload-timestamps")
    public ModelAndView uploadTimestamps(@RequestParam("file") MultipartFile file){
        int response = uploadTimestampsService.uploadTimestamps(file);
        if(response == 0){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/upload-data");
    }

    @GetMapping("/timestamps/{id}")
    public List<TimestampEntity> findByIdStaffAndDate(@PathVariable("id") Long idStaff,@RequestBody Date date){
        return timestampsService.findByIdStaffAndDate(idStaff, date);
    }
}

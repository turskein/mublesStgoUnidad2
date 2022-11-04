package tingeso.uploadtimestamps.controllers;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tingeso.uploadtimestamps.services.UploadTimestampsService;

@Controller
@RestController
@RequestMapping("/uploadtimestamps")
@Generated
public class UploadTimestampsController {
    @Autowired
    UploadTimestampsService uploadTimestampsService;

    @PostMapping("/upload-timestamps")
    public ModelAndView uploadTimestamps(@RequestParam("file") MultipartFile file){
        int response = uploadTimestampsService.uploadTimestamps(file);
        if(response == 0){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/upload-data");
    }
}

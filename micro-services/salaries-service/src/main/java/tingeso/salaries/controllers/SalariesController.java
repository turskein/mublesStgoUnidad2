package tingeso.salaries.controllers;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Generated;
import tingeso.salaries.models.SalaryModel;
import tingeso.salaries.services.GetSalaryForEveryStaff;

@Controller
@RestController
@RequestMapping("/salaries")
@Generated
public class SalariesController {

    @Autowired
    GetSalaryForEveryStaff getSalaryForEveryStaff;

    @GetMapping("/reports")
    public ResponseEntity<List<SalaryModel>> viewReportSalaries(@RequestParam int month, @RequestParam int year) {
        List<SalaryModel> everySalary = getSalaryForEveryStaff.getSalaryForEveryStaff(month, year);
        return ResponseEntity.ok(everySalary);
    }
}

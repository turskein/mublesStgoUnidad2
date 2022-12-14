package tingeso.salaries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.repositories.StaffRepository;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public StaffEntity findStaffByRut(String rut){
        List<StaffEntity> staffList = staffRepository.findByRut(rut);
        if(staffList.size() == 0){
            return null;
        }
        return staffList.get(0);
    }
}

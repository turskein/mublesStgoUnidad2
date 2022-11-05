package tingeso.salaries.services.salary.discounts;

import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.models.TimestampModel;
import tingeso.salaries.services.RequestService;
import tingeso.salaries.services.salary.discounts.DescByDelaySalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ApplyDscts {

    @Autowired
    DescByDelaySalary descByDelaySalary;

    @Autowired
    RequestService requestService;

    @Autowired
    MissingDay missingDay;

    @Autowired
    LimitsMonth limitsMonth;

    private double accumulatedDsctsToSalary(StaffEntity worker, int month, int year){
        Calendar start = Calendar.getInstance();
        start.setTime(limitsMonth.getStartDate(month,year));
        Calendar end = Calendar.getInstance();
        end.setTime(limitsMonth.getEndDate(month,year));
        double dsctos = 0;
        /*Iterations over day of month*/
        for (Date current = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), current = start.getTime()) {
            if(missingDay.isWorkableDay(current)){
                List<TimestampModel> currentTimestamps = requestService.timestampsGetByIdStaffAndDate(worker.getIdStaff(),current);
                if(missingDay.isMissingDay(currentTimestamps)){
                    dsctos = dsctos + missingDay.noWorkedDay;
                }else{
                    TimestampModel currentTimestamp = currentTimestamps.get(0);
                    if(descByDelaySalary.overSeventy(currentTimestamp)){
                        if(!currentTimestamps.isEmpty()){
                        }else {
                            dsctos = dsctos + missingDay.noWorkedDay;
                        }
                    }else {
                        dsctos = dsctos + descByDelaySalary.dsctoByDelay(currentTimestamp);
                    }

                }
            }
        }
        return dsctos;
    }

    public int applyDiscount(int salary, StaffEntity worker, int month, int year){
        return (int)(accumulatedDsctsToSalary(worker,month,year)*((double)salary));
    }

}

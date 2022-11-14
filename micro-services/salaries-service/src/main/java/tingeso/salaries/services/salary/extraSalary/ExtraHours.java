package tingeso.salaries.services.salary.extraSalary;


import tingeso.salaries.entities.CategoryEntity;
import tingeso.salaries.models.ExtraHoursModel;
import tingeso.salaries.entities.StaffEntity;
import tingeso.salaries.models.TimestampModel;
import tingeso.salaries.services.CategoryService;
import tingeso.salaries.services.salary.SalaryByCategory;
import tingeso.salaries.services.RequestService;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class ExtraHours {
    @Autowired
    RequestService requestService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SalaryByCategory salaryByCategory;

    private List<ExtraHoursModel> getExtraHoursByStaffAndDate(StaffEntity worker, int month, int year){
        return requestService.extraHoursfindAllByIdStaffAndMonthAndYear(worker.getIdStaff(),month,year);
    }

    private TimestampModel getTimeStampByWorkerAndDate(StaffEntity worker, Date date){
        try{
            return requestService.timestampsGetByIdStaffAndDate(worker.getIdStaff(),date).get(1);
        }catch (Exception e){
            return null;
        }

    }

    @Generated
    public Time getTimeFromTimestamp(TimestampModel timestamp){
        try{
            return timestamp.getTime();
        }catch (Exception e){
            return null;
        }
    }

    private Time lessOneHour(Time time){
        long oneHour = 3600000;
        return new Time(time.getTime()-oneHour);
    }

    private boolean thereAreTimeStamp(TimestampModel timestamp){
        return timestamp == null;
    }

    Time departureTime = new Time(16,0,0);

    @Generated
    private int validateExtraHours(StaffEntity worker,ExtraHoursModel extraHour){
        Date dateOfExtraHour = extraHour.getDate();

        TimestampModel timeStampOfDayExtraHours = getTimeStampByWorkerAndDate(worker, dateOfExtraHour);
        if(thereAreTimeStamp(timeStampOfDayExtraHours)){
            return 0;
        }

        Time timeOfTimeStamp = getTimeFromTimestamp(timeStampOfDayExtraHours);

        Time lessedTime = lessOneHour(timeOfTimeStamp);

        int validateExtraHours = 0;

        while(validateExtraHours < extraHour.getAmount() && lessedTime.after(departureTime)){
            lessedTime = lessOneHour(lessedTime);
            validateExtraHours ++;
        }

        return validateExtraHours;
    }

    public int salaryExtraHours(StaffEntity worker, CategoryEntity category, int month, int year){
        int amountOneExtraHours = salaryByCategory.getSalExtraHoursByCat(category);

        int validatedAmountExtraHour = 0;
        List<ExtraHoursModel> everyExtraHour = getExtraHoursByStaffAndDate(worker, month, year);
        if(everyExtraHour == null){
            return 0;
        }
        for(int i = 0; i < everyExtraHour.size(); i ++){
            validatedAmountExtraHour = validatedAmountExtraHour + validateExtraHours(worker,everyExtraHour.get(i));
        }

        return validatedAmountExtraHour*amountOneExtraHours;
    }

}

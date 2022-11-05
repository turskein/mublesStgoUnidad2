package tingeso.salaries.services.salary.discounts;

import tingeso.salaries.models.TimestampModel;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class MissingDay {

    SimpleDateFormat formatter = new SimpleDateFormat("EEEE", Locale.ENGLISH);

    String[] WorksDay = {"Monday", "Tuesday" ,"Thursday", "Wednesday", "Friday"};

    double noWorkedDay = 0.15;

    public boolean isWorkableDay(Date date){
        String weekDay = formatter.format(date);

        for (String workDay: WorksDay) {
            if(weekDay.equals(workDay)){
                return true;
            }
        }
        return false;
    }

    public boolean isMissingDay(List<TimestampModel> days){
        return !(days.size() > 0);
    }

}

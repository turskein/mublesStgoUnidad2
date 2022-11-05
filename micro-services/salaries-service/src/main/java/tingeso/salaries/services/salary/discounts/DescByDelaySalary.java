package tingeso.salaries.services.salary.discounts;

import tingeso.salaries.models.TimestampModel;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class DescByDelaySalary {

    Time tenMinuteDelay = new Time(8,10,0);
    Time twentyFiveMinuteDelay = new Time(8,25,0);
    Time fourtyFiveMinuteDelay = new Time(8,45,0);
    Time seventyMinuteDelay = new Time(9,10,0);

    double dsctoTen = 0.01;
    double dsctoTwentyFive = 0.03;
    double dsctoFourtyFive = 0.06;

    public boolean overSeventy(TimestampModel timestamp){
        return seventyMinuteDelay.before(timestamp.getTime());
    }

    public double dsctoByDelay(TimestampModel timestamp){
        if(fourtyFiveMinuteDelay.before(timestamp.getTime())){
            return dsctoFourtyFive;
        }else if(twentyFiveMinuteDelay.before(timestamp.getTime())){
            return dsctoTwentyFive;
        }else if (tenMinuteDelay.before(timestamp.getTime())) {
            return dsctoTen;
        }
        return 0;
    }
}

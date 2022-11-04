package tingeso.uploadtimestamps.services;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tingeso.uploadtimestamps.entities.TimestampEntity;
import tingeso.uploadtimestamps.repositories.TimestampRepository;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UploadTimestampsService {

    @Autowired
    TimestampRepository timestampRepository;

    SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat simpleDateFormatForTime = new SimpleDateFormat("hh:mm");
    @Generated
    private Date parseDate(String str){

        try{
            return simpleDateFormatForDate.parse(str);
        }catch(ParseException e){
            return null;
        }
    }

    @Generated
    private Time parseTime(String str){
        try{
            Long ms = simpleDateFormatForTime.parse(str).getTime();
            return new Time(ms);
        }catch(ParseException e){
            System.out.println(e);
            return null;
        }
    }

    private String rareSubstring(String str){
        return str.substring(0,str.length()-1);
    }

    private int saveNewTimeStamp(String rut, String date, String time) {
        TimestampEntity timestampEntityToBeUpload = new TimestampEntity();

        Date parsedDate = parseDate(date);
        if(parsedDate == null){
            return -1;
        }

        timestampEntityToBeUpload.setDate(parsedDate);
        Time parsedTime = parseTime(time);
        if(parsedTime == null){
            return -1;
        }
        timestampEntityToBeUpload.setTime(parsedTime);

        timestampRepository.save(timestampEntityToBeUpload);
        return 0;
    }

    @Generated
    private ArrayList<String> splitData(String data){

        String[] splitByNewLine = data.split("\n");

        ArrayList<String> splitByDotCom = new ArrayList<>();
        for (String dato : splitByNewLine){

            if(dato.length() > 10){
                String[] splitted = dato.split(";");
                splitByDotCom.add(splitted[0]);
                splitByDotCom.add(splitted[1]);
                splitByDotCom.add(splitted[2]);
            }
        }
        return splitByDotCom;
    }

    @Generated
    public String readMultipartFile(MultipartFile file){
        try{
            return new String(file.getBytes());
        }catch (IOException e){
        }
        return "";
    }

    public int uploadTimestamps(MultipartFile file) {
        String data = readMultipartFile(file)+" ";
        return uploadTimeStamps(data);
    }

    public int uploadTimeStamps(String allData){
        ArrayList<String> dataSplitted = splitData(allData);
        for(int i = 0; i < dataSplitted.size(); i = 3 + i) {
            try{
                if(saveNewTimeStamp(dataSplitted.get(i+2),dataSplitted.get(i),dataSplitted.get(i+1)) == -1){
                    return i+1;
                }
            }catch (Exception e){
                return 1;
            }
        }
        return 0;
    }
}

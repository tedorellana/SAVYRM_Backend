package SAVYRM.PROJECT.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilities {
    
    // Returns the current date time in format: yyyy-MM-dd-HH-mm-ss-ns
    public static String GetCurrentDateTime()
    {
        System.out.println("GetCurrentDataTime().");
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Date after formated : " + formattedDate);
        return formattedDate;
    }
}

import Dto.TimeZoneInformationDto;
import service.Service;

import java.time.LocalDateTime;


public class Main {
    public static void main (String[] args) {
        Service service = new Service();
        TimeZoneInformationDto timezoneInformationDto = service.getDateTimeForTimezone(args);
        if(timezoneInformationDto != null) {
            LocalDateTime localDateTime = timezoneInformationDto.getDateTime();
            String timezone = timezoneInformationDto.getTimezone();

            System.out.println("Date and time for timezone: " + timezone);
            System.out.println("date: " + localDateTime.getYear() + "-" + localDateTime.getMonth() + "-" + localDateTime.getDayOfMonth());
            System.out.println("time: " + localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond());
        }
    }
}

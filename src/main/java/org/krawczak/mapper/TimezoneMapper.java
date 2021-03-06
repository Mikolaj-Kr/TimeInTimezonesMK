package org.krawczak.mapper;

import org.krawczak.dto.TimeZoneInformationDto;
import org.krawczak.api.TimeZoneInformation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimezoneMapper {

    public TimeZoneInformationDto mapTimezoneInformationToTimezoneInformationDto(TimeZoneInformation timezoneInformation) {

        String timezone = timezoneInformation.getTimezone();
        LocalDateTime localDateTime = mapDateTimeToLocalDateTime(timezoneInformation.getDateTime());

        return new TimeZoneInformationDto(timezone, localDateTime);
    }

    private LocalDateTime mapDateTimeToLocalDateTime(String datetime) {

        String[] dateAndTimeArray = datetime.split("T");
        String[] dateArray = dateAndTimeArray[0].split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        LocalDate localDate = LocalDate.of(year, month, day);

        String[] timeAndUtcInfoArray = dateAndTimeArray[1].split("\\.");
        String[] timeArray = timeAndUtcInfoArray[0].split(":");
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);
        LocalTime localTime = LocalTime.of(hours, minutes, seconds);

        return LocalDateTime.of(localDate, localTime);
    }
}

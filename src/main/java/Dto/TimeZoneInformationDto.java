package Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeZoneInformationDto {

    private String timezone;

    private LocalDateTime dateTime;
}

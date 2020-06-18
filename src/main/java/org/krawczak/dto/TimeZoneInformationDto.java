package org.krawczak.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeZoneInformationDto {

    private String timezone;

    private LocalDateTime dateTime;

    public TimeZoneInformationDto(String timezone, LocalDateTime dateTime) {
        this.timezone = timezone;
        this.dateTime = dateTime;
    }
}

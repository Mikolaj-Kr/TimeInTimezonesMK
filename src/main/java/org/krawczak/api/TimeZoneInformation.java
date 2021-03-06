package org.krawczak.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZoneInformation {

    @JsonProperty("datetime")
    private String dateTime;

    @JsonProperty("timezone")
    private String timezone;
}

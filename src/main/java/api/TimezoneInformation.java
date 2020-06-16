package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimezoneInformation {

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("utc_offset")
    private String utcOffset;

    @JsonProperty("timezone")
    private String timezone;
}

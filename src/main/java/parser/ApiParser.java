package parser;

import api.TimeZoneInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.util.List;

public class ApiParser {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String requestUri = "http://worldtimeapi.org/api/timezone/";

    public List<String> getTimezonesFromApi() throws UnirestException, JsonProcessingException {

        HttpResponse<String> response = Unirest.get(requestUri).asString();
        return objectMapper.readValue(response.getBody(), new TypeReference<List<String>>() {});
    }

    public TimeZoneInformation getTimezoneInformation(String timezone) throws UnirestException, JsonProcessingException {

        HttpResponse<String> response = Unirest.get(requestUri + timezone).asString();
        return objectMapper.readValue(response.getBody(), TimeZoneInformation.class);
    }
}

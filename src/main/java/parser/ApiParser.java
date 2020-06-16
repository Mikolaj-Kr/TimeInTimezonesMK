package parser;

import api.TimezoneInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public class ApiParser {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String requestUri = "http://worldtimeapi.org/api/timezone";

    public List<String> getTimezonesFromApi() throws UnirestException, JsonProcessingException {

        HttpResponse<String> response = Unirest.get(requestUri).asString();
        return objectMapper.readValue(response.getBody(), new TypeReference<List<String>>() {
        });
    }

    public List<String> getLocationsForArea(String area) throws JsonProcessingException, UnirestException {

        HttpResponse<String> response = Unirest.get(requestUri + area).asString();
        return objectMapper.readValue(response.getBody(), new TypeReference<List<String>>() {
        });
    }

    public TimezoneInformation getTimezoneInformation(String timezone) throws UnirestException, JsonProcessingException {

        HttpResponse<String> response = Unirest.get(requestUri + timezone).asString();
        return objectMapper.readValue(response.getBody(), TimezoneInformation.class);
    }
}

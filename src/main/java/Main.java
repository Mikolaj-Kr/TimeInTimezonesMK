import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import parser.ApiParser;

import java.time.LocalDate;


public class Main {
    public static void main (String[] args) throws JsonProcessingException, UnirestException {
        ApiParser apiParser = new ApiParser();
        System.out.println(apiParser.getTimezoneInformation("/Europe/Berlin").getDatetime());

    }
}

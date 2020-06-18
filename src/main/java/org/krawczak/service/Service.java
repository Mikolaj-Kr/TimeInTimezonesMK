package org.krawczak.service;

import org.krawczak.Dto.TimeZoneInformationDto;
import org.krawczak.api.TimeZoneInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import kong.unirest.UnirestException;
import org.krawczak.mapper.TimezoneMapper;
import org.krawczak.parser.ApiParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    private final ApiParser apiParser = new ApiParser();
    private final TimezoneMapper timezoneMapper = new TimezoneMapper();

    public TimeZoneInformationDto getTimeZoneInformationDto(String[] timezoneFromUser) {

        String timezone = findCorrectTimezone(timezoneFromUser);
        if (timezone.equals("no results")) {
            System.out.println("no results, give as a parameter one of the time zone:");
            List<String> timezones = getTimezones();
            timezones.forEach(t -> System.out.println(t));
            System.out.println("give as a parameter one of the above time zones");
            return null;
        } else if (timezone.equals("API not available")) {
            System.out.println("API not available");
            return null;
        }
        TimeZoneInformation timezoneInformation = null;

        try {
            timezoneInformation = apiParser.getTimezoneInformation(timezone);
        } catch (UnirestException | JsonProcessingException e) {
            System.out.println("API not available");
        }
        TimeZoneInformationDto timezoneInformationDto = timezoneMapper.mapTimezoneInformationToTimezoneInformationDto(timezoneInformation);
        return timezoneInformationDto;
    }

    private List<String> getTimezones() {
        List<String> timezonesList = new ArrayList<>();
        try {
            timezonesList.addAll(apiParser.getTimezonesFromApi());
        } catch (UnirestException | JsonProcessingException e) {
            timezonesList.add("API not available");
        }
        return timezonesList;
    }

    private String findCorrectTimezone(String[] timezoneFromUser) {
        List<String> userParameters = new ArrayList<>();
        for (String singleParameter : timezoneFromUser) {
            if (singleParameter.contains("/")) {
                userParameters.addAll(Arrays.asList(singleParameter.split("/")));
            } else {
                userParameters.add(singleParameter);
            }
        }

        List<String> timezonesFromApi = new ArrayList<>();
        int resultsNumber;
        String correctTimeZone = "no results";
        boolean apiAvailable = true;
        try {
            timezonesFromApi.addAll(apiParser.getTimezonesFromApi());
        } catch (UnirestException | JsonProcessingException e) {
            correctTimeZone = "API not available";
            apiAvailable = false;
        }

        if (apiAvailable) {
            for (String userParameter : userParameters) {
                resultsNumber = 0;
                correctTimeZone = "no results";
                for (String timeZone : timezonesFromApi) {
                    if (timeZone.contains(userParameter)) {
                        String[] timezoneArray = timeZone.split("/");
                        if (timezoneArray[timezoneArray.length - 1].equalsIgnoreCase(userParameter)) {
                            resultsNumber++;
                            correctTimeZone = timeZone;
                        }
                    }
                }
                if (resultsNumber == 1) {
                    break;
                }
            }
        }
        return correctTimeZone;
    }
}

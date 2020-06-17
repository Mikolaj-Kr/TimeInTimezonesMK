import Dto.TimeZoneInformationDto;
import api.TimeZoneInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import mapper.TimezoneMapper;
import org.junit.Assert;
import org.junit.Test;
import parser.ApiParser;

public class MapperTest {

    @Test
    public void testDataTimeToLocalDataTimeMapper() throws JsonProcessingException, UnirestException {

        //given
        TimezoneMapper timezoneMapper = new TimezoneMapper();
        ApiParser apiParser = new ApiParser();

        //when
        TimeZoneInformation timezoneInformation = apiParser.getTimezoneInformation("/Europe/Warsaw");
        String [] dateAndTimeArray = timezoneInformation.getDateTime().split("T");
        String [] dateArray = dateAndTimeArray[0].split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        String [] timeAndUtcInfoArray = dateAndTimeArray[1].split("\\.");
        String [] timeArray = timeAndUtcInfoArray[0].split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        int second = Integer.parseInt(timeArray[2]);

        TimeZoneInformationDto timezoneInformationDto = timezoneMapper.mapTimezoneInformationToTimezoneInformationDto(timezoneInformation);

        //then
        Assert.assertEquals(timezoneInformationDto.getDateTime().getYear(), year);
        Assert.assertEquals(timezoneInformationDto.getDateTime().getMonthValue(), month);
        Assert.assertEquals(timezoneInformationDto.getDateTime().getDayOfMonth(), day);
        Assert.assertEquals(timezoneInformationDto.getDateTime().getHour(), hour);
        Assert.assertEquals(timezoneInformationDto.getDateTime().getMinute(), minute);
        Assert.assertEquals(timezoneInformationDto.getDateTime().getSecond(), second);
        Assert.assertEquals(timezoneInformationDto.getTimezone(), timezoneInformation.getTimezone());
    }
}

import Dto.TimeZoneInformationDto;
import api.TimeZoneInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import parser.ApiParser;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @Test
    public void testTimezoneParser() throws JsonProcessingException {

        //given
        ApiParser apiParser = new ApiParser();

        //when
        TimeZoneInformation case1 = apiParser.getTimezoneInformation("Europe/Warsaw");
        TimeZoneInformation case2 = apiParser.getTimezoneInformation("Etc/GMT+1");
        TimeZoneInformation case3 = apiParser.getTimezoneInformation("Etc/GMT-1");

        //then
        Assert.assertEquals(case1.getTimezone(), "Europe/Warsaw");
        Assert.assertEquals(case2.getTimezone(), "Etc/GMT+1");
        Assert.assertEquals(case3.getTimezone(), "Etc/GMT-1");
    }
}

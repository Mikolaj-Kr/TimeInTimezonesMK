import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;
import parser.ApiParser;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @Test
    public void testLocationsForArea() throws JsonProcessingException, UnirestException {

        //given
        ApiParser apiParser = new ApiParser();

        //when
        List<String> results = apiParser.getLocationsForArea("Europe");
        List<String[]> splitResults = new ArrayList<>();
        results.forEach(s -> splitResults.add(s.split("/")));

        //then
        splitResults.forEach(s -> Assert.assertEquals(s[0], "Europe"));
    }
}

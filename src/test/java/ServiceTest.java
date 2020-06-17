import Dto.TimeZoneInformationDto;
import org.junit.Assert;
import org.junit.Test;
import service.Service;

public class ServiceTest {

    private final Service service = new Service();

    @Test
    public void TestMethodGetTimeZoneInformationDtoForOthersFormOfParameters() {

        //given
        String[] sample1 = {"Warsaw"};
        String[] sample2 = {"Europe/Warsaw"};
        String[] sample3 = {"Europe Warsaw"};
        String[] sample4 = {"Europe", "Warsaw"};


        //when
        TimeZoneInformationDto case1 = service.getTimeZoneInformationDto(sample1);
        TimeZoneInformationDto case2 = service.getTimeZoneInformationDto(sample2);
        TimeZoneInformationDto case3 = service.getTimeZoneInformationDto(sample3);
        TimeZoneInformationDto case4 = service.getTimeZoneInformationDto(sample4);


        //then
        Assert.assertEquals(case1.getTimezone(), "Europe/Warsaw");
        Assert.assertEquals(case2.getTimezone(), "Europe/Warsaw");
        Assert.assertEquals(case3.getTimezone(), "Europe/Warsaw");
        Assert.assertEquals(case4.getTimezone(), "Europe/Warsaw");


    }

    @Test
    public void TestMethodGetTimeZoneInformationForOtherLocations() {

        //given
        String[] sample1 = {"GMT+7"};
        String[] sample2 = {"Tell_City"};
        String[] sample3 = {"WET"};

        //when
        TimeZoneInformationDto case1 = service.getTimeZoneInformationDto(sample1);
        TimeZoneInformationDto case2 = service.getTimeZoneInformationDto(sample2);
        TimeZoneInformationDto case3 = service.getTimeZoneInformationDto(sample3);

        //then
        Assert.assertEquals(case1.getTimezone(), "Etc/GMT+7");
        Assert.assertEquals(case2.getTimezone(), "America/Indiana/Tell_City");
        Assert.assertEquals(case3.getTimezone(), "WET");
    }
}

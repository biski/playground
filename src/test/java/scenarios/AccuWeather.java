package scenarios;

import engine.TestInstance;
import engine.annotations.UseBrowser;
import org.testng.annotations.Test;
import pages.accuweather.MainPage;

import static engine.Browser.*;

/**
 * Created by wojciech on 15.06.17.
 */
public class AccuWeather extends TestInstance {

    @Test
    @UseBrowser(type = BROWSER_TYPE.FIREFOX)
    public void getWeatherForCracov() {

        String CITY = "Krakow, Poland";

        getDriver().get("http://www.accuweather.com");

        new MainPage(this)
                .getSearch()
                .clickSearch()
                .fillSearchInput(CITY)
                .chooseCity(CITY);



    }
}

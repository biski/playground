package pages.accuweather;

import engine.Page;
import engine.TestInstance;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by wojciech on 15.06.17.
 */
public class MenuCities extends Page {

    public MenuCities(TestInstance testInstance) {
        super(testInstance, By.id("menu-cities"));
    }

    @Step
    public Forecast chooseCity(String name) {

        find(cityWithName(name)).click();

        waitFor().maxTime(10, TimeUnit.SECONDS).visibility(new NavMain(testInstance).loadedCity("Krakow"));

        assertThat().page().titleContainsText("Krakow Weather");
        assertThat().element().withName("Forecast for tonight").exists(new FeedTabs(testInstance).tabForDay("Tonight"));

        return new Forecast(testInstance);
    }

    public By cityWithName(String name) {
        return locate(By.xpath(".//a[contains(text(), '" + name + "')]"));
    }
}

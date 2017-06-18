package pages.accuweather;

import engine.Page;
import engine.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by wojciech on 15.06.17.
 */
public class NavMain extends Page {
    public NavMain(TestInstance testInstance) {
        super(testInstance, By.id("nav-main-add-interests"));
    }


    public By loadedCity(String city) {
        return locate(By.xpath(".//span[@class = 'current-city']/h1[contains(text(), '" + city + "')]"));
    }
}

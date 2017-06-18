package pages.accuweather;

import engine.Page;
import engine.TestInstance;
import engine.tools.ScreenShot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

/**
 * Created by wojciech on 15.06.17.
 */
public class Search extends Page {

    private final By SEARCH_INPUT = By.id("s");

    public Search(TestInstance testInstance) {
        super(testInstance, By.id("findcity"));
    }

    @Step
    public Search click() {

        find(locate(SEARCH_INPUT)).click();

        ScreenShot.makeScreenShotWithElementMarked(testInstance.getDriver(),
                find(locate(SEARCH_INPUT)));

        return this;
    }

    @Step
    public MenuCities search(String city) {

        find(locate(SEARCH_INPUT)).sendKeys(city);

        waitFor().visibility(new MenuCities(testInstance).cityWithName(city));

        return new MenuCities(testInstance);
    }
}

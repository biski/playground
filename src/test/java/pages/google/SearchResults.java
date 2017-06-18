package pages.google;

import engine.Page;
import engine.TestInstance;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Created by wojciech on 15.04.17.
 */
public class SearchResults extends Page {

    public SearchResults(TestInstance testInstance) {
        super(testInstance);
    }


    @Step
    public int resultsOnPage() {

        return testInstance.getDriver().findElements(By.className("g")).size();
    }
}

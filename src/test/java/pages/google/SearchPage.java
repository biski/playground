package pages.google;


import engine.Page;
import engine.TestInstance;
import engine.elements.Input;
import engine.elements.Submit;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage extends Page {

    public SearchPage(TestInstance testInstance) {
        super(testInstance);
    }

    @Step
    public SearchPage open() {
        testInstance.getDriver().get("https://google.pl");
        return this;
    }

    @Step
    public SearchPage setSearchText(String text) {
        new Input(testInstance, By.name("q")).setValue(text);

        return this;
    }

    @Step
    public SearchResults search() {
        new Submit(testInstance, By.name("btnK"));

        return new SearchResults(testInstance);
    }
}

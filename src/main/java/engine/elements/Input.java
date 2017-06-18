package engine.elements;

import engine.Element;
import engine.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by wojciech on 15.04.17.
 */
public class Input extends Element {
    private By by;
    private WebElement input;

    public Input(TestInstance testInstance, By by) {
        super(testInstance);

        input = testInstance.getDriver().findElement(by);
    }

    public Input setValue(String value) {

        input.sendKeys(value);

        return this;
    }
}

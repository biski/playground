package engine.elements;

import engine.Element;
import engine.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by wojciech on 15.04.17.
 */
public class Submit extends Element {

    private By by;
    private WebElement submit;

    public Submit(TestInstance testInstance, By by) {
        super(testInstance);
        this.by = by;

        testInstance.getDriver().findElement(by);
    }

    public Submit submit() {
        submit.click();

        return this;
    }


}

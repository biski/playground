package engine.tools.assertions;

import engine.TestInstance;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.Assertion;

/**
 * Created by wojciech on 16.06.17.
 */
public class ElementAssertions {

    private TestInstance testInstance;
    private String name;

    public ElementAssertions(TestInstance testInstance) {
        this.testInstance = testInstance;
    }

    public ElementAssertions withName(String name) {
        this.name = name;
        return this;
    }

    public ElementAssertions exists(By by) {
        if(testInstance.getDriver().findElements(by).size() == 0) {
            Assert.fail("Element " + name + " doesn't exists.");
        }
        return this;
    }
}

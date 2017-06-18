package engine.tools.assertions;

import engine.TestInstance;
import org.testng.Assert;

/**
 * Created by wojciech on 16.06.17.
 */
public class PageAssertions {
    private TestInstance testInstance;

    public PageAssertions(TestInstance testInstance) {
        this.testInstance = testInstance;
    }

    public PageAssertions titleIsEqualTo(String expectedTitle) {
        Assert.assertEquals(
                testInstance.getDriver().getTitle(),
                expectedTitle
        );
        return this;
    }

    public PageAssertions titleContainsText(String text) {
        if( ! testInstance.getDriver().getTitle().contains(text)) {
            Assert.fail("Page title doesn't contain [" + text + "]");
        }

        return this;
    }
}

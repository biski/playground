package engine.tools;

import engine.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by wojciech on 16.06.17.
 */
public class WaitTool {
    private TestInstance testInstance;
    private long timeout = TestInstance.WAIT_TIME;
    private WebDriverWait wait;
    private String desc;

    public WaitTool(TestInstance testInstance) {
        this.testInstance = testInstance;
        wait = new WebDriverWait(testInstance.getDriver(), timeout);
    }

    public WaitTool maxTime(int value, TimeUnit timeUnit) {
        timeout = timeUnit.toSeconds(value);
        wait = new WebDriverWait(testInstance.getDriver(), timeout);
        return this;
    }

    public WebElement visibility(By by) {
        try {
            return wait
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail((desc != null ? desc : "Element") + " is not visible after " + timeout + "s", e);
        }
        return null;
    }

    public void invisibily(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WaitTool withDesc(String desc) {
        this.desc = desc;
        return this;
    }
}

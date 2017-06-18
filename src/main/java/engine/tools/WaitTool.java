package engine.tools;

import engine.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by wojciech on 16.06.17.
 */
public class WaitTool {
    private TestInstance testInstance;
    private long timeout = TestInstance.WAIT_TIME;
    private WebDriverWait wait;

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
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void invisibily(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}

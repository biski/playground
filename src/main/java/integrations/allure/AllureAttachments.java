package integrations.allure;

import engine.TestInstance;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Created by wojciech on 04.11.17.
 */
public class AllureAttachments {

    @Attachment("Screenshot after test")
    public static byte[] attachScreenshoot(TestInstance testInstance) {
        return ((TakesScreenshot) testInstance.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

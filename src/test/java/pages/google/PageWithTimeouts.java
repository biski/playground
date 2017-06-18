package pages.google;

import engine.Page;
import engine.TestInstance;
import engine.annotations.Timeout;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

/**
 * Created by wojciech on 22.04.17.
 */
public class PageWithTimeouts extends Page {
    public PageWithTimeouts(TestInstance testInstance) {
        super(testInstance);
    }

    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @Step
    public void longMethod()  {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        } catch (InterruptedException ignored) {}
    }

    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @Step
    public void shortMethod()  {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException ignored) { }
    }
}

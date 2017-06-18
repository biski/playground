package scenarios;

import pages.google.PageWithTimeouts;
import engine.TestInstance;
import org.testng.annotations.Test;

/**
 * Created by wojciech on 22.04.17.
 */
public class TimeoutTest extends TestInstance {

    @Test(expectedExceptions = {com.google.common.util.concurrent.UncheckedTimeoutException.class})
    public void timeoutExceedTest() {
        new PageWithTimeouts(this).longMethod();
    }

    @Test
    public void timeoutNotExceedTest() {
        new PageWithTimeouts(this).shortMethod();
    }
}

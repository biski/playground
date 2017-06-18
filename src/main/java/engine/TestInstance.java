package engine;

import engine.listeners.TestListener;
import engine.reports.TestProgress;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class TestInstance {
    private WebDriver driver;
    private Browser browser;

    public static final int WAIT_TIME = 10;

    public TestInstance() {
        TestProgress.getInstance().incrementAll(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public TestInstance setDriver(WebDriver driver) {
        this.driver = driver;
        this.browser = new Browser(driver);
        return this;
    }

    public Browser getBrowser() {
        return browser;
    }

    public TestInstance setBrowser(Browser browser) {
        this.browser = browser;
        return this;
    }
}

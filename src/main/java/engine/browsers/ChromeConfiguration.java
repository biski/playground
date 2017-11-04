package engine.browsers;

import com.typesafe.config.ConfigFactory;
import engine.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

/**
 * Created by wojciech on 03.11.17.
 */
public class ChromeConfiguration {
    public void run(TestInstance testInstance) {
        System.setProperty("webdriver.chrome.driver", ConfigFactory.load().getString("chrome.driver-path"));


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(ConfigFactory.load().getBoolean("chrome.headless"));


        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);



        ChromeDriver driver = new ChromeDriver(chromeOptions);

        testInstance.setDriver(driver);
    }
}

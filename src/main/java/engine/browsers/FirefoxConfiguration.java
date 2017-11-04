package engine.browsers;

import com.typesafe.config.ConfigFactory;
import engine.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Created by wojciech on 03.11.17.
 */
public class FirefoxConfiguration {
    public void configure() {

    }

    public void run(TestInstance testInstance) {
        System.setProperty("webdriver.gecko.driver", ConfigFactory.load().getString("firefox.gecko-path"));
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        testInstance.setDriver(firefoxDriver);
        setFirefoxPid(testInstance, firefoxDriver);
    }

    private void setFirefoxPid(TestInstance testInstance, FirefoxDriver firefoxDriver) {
        String pid = firefoxDriver.getCapabilities().getCapability("moz:processID").toString();
        System.out.println("processId: " + pid);
        testInstance.getBrowser().setPid(((Double)Double.parseDouble(pid)).intValue());
    }
}

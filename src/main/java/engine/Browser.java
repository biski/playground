package engine;

import org.openqa.selenium.WebDriver;


/**
 * Created by wojciech on 15.06.17.
 */
public class Browser {


    public enum BROWSER_TYPE {
        FIREFOX, CHROME
    }

    private int pid;
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;

    }


    public int getPid() {
        return pid;
    }

    public Browser setPid(int pid) {
        this.pid = pid;
        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Browser setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }
}

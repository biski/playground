package pages.accuweather;

import engine.Page;
import engine.TestInstance;
import org.openqa.selenium.By;

/**
 * Created by wojciech on 15.06.17.
 */
public class Forecast extends Page {
    public Forecast(TestInstance testInstance) {
        super(testInstance, By.id("content"));
    }
}

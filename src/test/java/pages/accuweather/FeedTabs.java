package pages.accuweather;

import engine.Page;
import engine.TestInstance;
import org.openqa.selenium.By;

/**
 * Created by wojciech on 16.06.17.
 */
public class FeedTabs extends Page {
    public FeedTabs(TestInstance testInstance) {
        super(testInstance, By.id("feed-tabs"));
    }

    public FeedTab getTab(String day) {
        return new FeedTab(testInstance, tabForDay(day));
    }

    public By tabForDay(String day) {
        return locate(By.xpath(".//li[//h3/a[text() = '" + day + "']]"));
    }
}

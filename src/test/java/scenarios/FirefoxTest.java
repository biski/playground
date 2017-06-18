package scenarios;

import engine.annotations.UseBrowser;
import pages.google.SearchPage;
import bootstrap.elements.Box;
import pages.google.SearchResults;
import engine.TestInstance;
import org.testng.annotations.Test;

/**
 * Created by wojciech on 15.04.17.
 */
public class FirefoxTest extends TestInstance {

    @Test
    @UseBrowser
    public void runFirefox() {

        new Box(this)
                .withTitle("Standard select boxes");


        new SearchPage(this)
                .open()
                .setSearchText("selenium");

        new SearchResults(this);



    }


}

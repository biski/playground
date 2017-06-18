package pages.accuweather;

import engine.Page;
import engine.TestInstance;

/**
 * Created by wojciech on 15.06.17.
 */
public class MainPage extends Page {
    public MainPage(TestInstance testInstance) {
        super(testInstance);
    }


    public Search getSearch() {
        return new Search(testInstance);
    }
}

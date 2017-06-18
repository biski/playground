package engine;

import org.openqa.selenium.WebDriver;

/**
 * Created by wojciech on 15.04.17.
 */
public class SELFRA {


    private WebDriver driver;

    public static SELFRA getInstance() {
        return SelfraInstance.instance;
    }



    private static class SelfraInstance {
        public static SELFRA instance = new SELFRA();
    }

    private SELFRA(){}


}

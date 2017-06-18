package bootstrap.elements;

import engine.Element;
import engine.TestInstance;
import org.openqa.selenium.By;

/**
 * Created by wojciech on 15.04.17.
 */
public class Box extends Element {

    private String title;
    private By box;

    private TestInstance testInstance;

    public Box(TestInstance testInstance) {
        super(testInstance);
        this.testInstance = testInstance;
    }

    public Box withTitle(String title) {

        this.title = title;

        return this;
    }


}

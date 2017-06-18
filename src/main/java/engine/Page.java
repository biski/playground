package engine;

import engine.tools.Assertions;
import engine.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

/**
 * Created by wojciech on 15.04.17.
 */
public abstract class Page {
    protected TestInstance testInstance;
    private By container;

    public Page(TestInstance testInstance) {
        this.testInstance = testInstance;
    }

    public Page(TestInstance testInstance, By container) {
        this.testInstance = testInstance;
        this.container = container;
    }

    public By locate(By... by) {
          return new ByChained(container, new ByChained(by));
    }

    public WebElement find(By by) {
        return testInstance.getDriver().findElement(by);
    }

    public List<WebElement> findAll(By by) {
        return testInstance.getDriver().findElements(by);
    }

    public Assertions assertThat() {
        return new Assertions(testInstance);
    }

    public WaitTool waitFor() {
        return new WaitTool(testInstance);
    }
}

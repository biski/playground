package engine.tools;

import engine.TestInstance;
import engine.tools.assertions.ElementAssertions;
import engine.tools.assertions.PageAssertions;

/**
 * Created by wojciech on 16.06.17.
 */
public class Assertions {

    private TestInstance testInstance;

    public Assertions(TestInstance testInstance) {
        this.testInstance = testInstance;
    }

    public ElementAssertions element() {
        return new ElementAssertions(testInstance);
    }

    public ElementAssertions element(String name) {
        return new ElementAssertions(testInstance).withName(name);
    }

    public PageAssertions page() {
        return new PageAssertions(testInstance);
    }
}

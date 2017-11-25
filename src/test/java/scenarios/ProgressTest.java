package scenarios;

import engine.TestInstance;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertTrue;

/**
 * Created by wojciech on 23.04.17.
 */
public class ProgressTest extends TestInstance {

    ByteArrayOutputStream baos;
    PrintStream ps;
    PrintStream old;

    @BeforeTest
    public void beforeTest() {
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        old = System.out;
        System.setOut(ps);
    }

    @Test
    public void progressTest1() {

    }
    @Test(dependsOnMethods = {"progressTest1"})
    public void progressTest2() {

    }
    @Test(dependsOnMethods = {"progressTest2"})
    public void progressTest3() {

    }

    @Test(dependsOnMethods = {"progressTest3"})
    public void checkProgress() {
        System.out.flush();
        System.setOut(old);
        System.out.println("Stdout: ");
        System.out.println(baos.toString());
        System.out.println("Checking..");
        assertTrue(baos.toString().contains("[0%..................................................]"));
        assertTrue(baos.toString().contains("[############25%......................................]"));
        assertTrue(baos.toString().contains("[#########################50%.........................]"));
        assertTrue(baos.toString().contains("[#####################################75%.............]"));
        System.out.println("Progress OK");
    }

}

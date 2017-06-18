import engine.TestInstance;
import org.reflections.Reflections;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import scenarios.TimeoutTest;

import java.util.Set;

/**
 * Created by wojciech on 23.04.17.
 */
public class TestNGProgrammatically {
    public static void main(String[] args) {

        TestNG testNG = new TestNG();

//        XmlSuite xmlSuite = new XmlSuite();
//        xmlSuite.setName("Generated XML Suite");
//        testNG.setXmlSuites(Collections.singletonList(xmlSuite));

        Reflections reflections = new Reflections("scenarios");
        Set<Class<? extends TestInstance>> classes = reflections.getSubTypesOf(TestInstance.class);

        System.out.println(classes.size());


        testNG.setOutputDirectory("target/");

        testNG.setThreadCount(5);
        testNG.setParallel(XmlSuite.ParallelMode.CLASSES);
        testNG.setTestClasses(new Class[]{TimeoutTest.class});
        testNG.run();


    }
}

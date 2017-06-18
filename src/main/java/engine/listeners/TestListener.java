package engine.listeners;

import engine.TestInstance;
import engine.annotations.UseBrowser;
import engine.reports.TestProgress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by wojciech on 15.04.17.
 */
public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);

        TestInstance testInstance = (TestInstance)tr.getInstance();
        if(tr.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(UseBrowser.class)) {
            closeBrowser(testInstance);
        }

        TestProgress.getInstance().incrementDone();
        TestProgress.getInstance().print();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);


        TestInstance testInstance = (TestInstance)tr.getInstance();


        Throwable throwable = tr.getThrowable();

        String functionFromPage = "";
        for (StackTraceElement stackTraceElement : tr.getThrowable().getStackTrace()) {
            if(stackTraceElement.getClassName().contains("pages.")) {
                functionFromPage = stackTraceElement.getMethodName();
            }
        }

        Throwable newThrowable = new AssertionError(
                "Cannot " + splitCamelCase(functionFromPage) +", " + throwable.getMessage(),
                throwable);
        tr.setThrowable(newThrowable);

        if(tr.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(UseBrowser.class)) {
            closeBrowser(testInstance);
        }


        TestProgress.getInstance().incrementDone();
        TestProgress.getInstance().print();
    }

    private void closeBrowser(TestInstance testInstance) {
        WebDriver driver = testInstance.getDriver();
        if(driver!= null) driver.quit();
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
        super.onTestFailedButWithinSuccessPercentage(tr);
    }

    @Override
    protected ITestNGMethod[] getAllTestMethods() {
        return super.getAllTestMethods();
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);

    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }

    @Override
    public List<ITestResult> getFailedButWithinSuccessPercentageTests() {
        return super.getFailedButWithinSuccessPercentageTests();
    }

    @Override
    public List<ITestResult> getFailedTests() {
        return super.getFailedTests();
    }

    @Override
    public List<ITestResult> getPassedTests() {
        return super.getPassedTests();
    }

    @Override
    public List<ITestResult> getSkippedTests() {
        return super.getSkippedTests();
    }

    @Override
    public void setAllTestMethods(List<ITestNGMethod> allTestMethods) {
        super.setAllTestMethods(allTestMethods);
    }

    @Override
    public void setFailedButWithinSuccessPercentageTests(List<ITestResult> failedButWithinSuccessPercentageTests) {
        super.setFailedButWithinSuccessPercentageTests(failedButWithinSuccessPercentageTests);
    }

    @Override
    public void setFailedTests(List<ITestResult> failedTests) {
        super.setFailedTests(failedTests);
    }

    @Override
    public void setPassedTests(List<ITestResult> passedTests) {
        super.setPassedTests(passedTests);
    }

    @Override
    public void setSkippedTests(List<ITestResult> skippedTests) {
        super.setSkippedTests(skippedTests);
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        TestProgress.getInstance().incrementRunning();
        TestProgress.getInstance().print();


        if (result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(UseBrowser.class)) {
            openBrowser(result);
        }



    }

    private void openBrowser(ITestResult result) {
        TestInstance instance = (TestInstance) result.getInstance();
        System.setProperty("webdriver.gecko.driver", "/home/wojciech/apps/geckodriver/geckodriver");
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        instance.setDriver(firefoxDriver);
        String pid = firefoxDriver.getCapabilities().getCapability("moz:processID").toString();
        System.out.println("processId: " + pid);
        instance.getBrowser().setPid(((Double)Double.parseDouble(pid)).intValue());
    }

    @Override
    public List<ITestContext> getTestContexts() {
        return super.getTestContexts();
    }

    @Override
    public List<ITestResult> getConfigurationFailures() {
        return super.getConfigurationFailures();
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        super.onConfigurationFailure(itr);
    }

    @Override
    public List<ITestResult> getConfigurationSkips() {
        return super.getConfigurationSkips();
    }

    @Override
    public void beforeConfiguration(ITestResult tr) {
        super.beforeConfiguration(tr);
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        super.onConfigurationSkip(itr);
    }

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        super.onConfigurationSuccess(itr);
    }


    static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }
}

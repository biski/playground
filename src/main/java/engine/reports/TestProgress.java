package engine.reports;

import engine.TestInstance;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by wojciech on 22.04.17.
 */
public class TestProgress {

    // progress bar width (in chars)
    private static final int PROGRESS_WIDTH = 50;

    private TestProgress() {
    }

    private int all, running, done;

    public void incrementAll(TestInstance testInstance) {
        all += countMethodsWithTestAnnotation(testInstance);
    }

    private int countMethodsWithTestAnnotation(TestInstance testInstance) {
        return (int) Arrays.stream(testInstance.getClass().getMethods())
                .filter(x -> x.isAnnotationPresent(Test.class))
                .count();
    }

    public void incrementRunning() {
        running++;
    }

    public void incrementDone() {
        done++;
        running--;
    }

    public void print() {
        printProgress((double) done / all * 1.00);
    }

    private void printProgress(double progressPercentage) {

        System.out.print("[");
        int i = (int)(progressPercentage * PROGRESS_WIDTH);
        IntStream.range(0, i).forEach(x -> System.out.print("#"));
        System.out.print((int)(progressPercentage * 100) + "%");
        IntStream.range(i, PROGRESS_WIDTH).forEach(x -> System.out.print("."));
        System.out.print("]\n");
    }

    private static class TestProgressHolder {
        private static final TestProgress INSTANCE = new TestProgress();
    }

    public static TestProgress getInstance() {
        return TestProgressHolder.INSTANCE;
    }
}

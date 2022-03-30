package ninja.lara.and.dnc.mergesort;

import ninja.lara.and.measurement.ExecutionTimer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortThreadedDnCTest {
    @Test
    public void doesMergeSortDnC() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), new MergeSortThreadedDnC(Arrays.asList(4, 3, 1, 2)).divideAndConquer().value);
        Assert.assertEquals(Arrays.asList(1, 2, 3), new MergeSortThreadedDnC(Arrays.asList(3, 2, 1)).divideAndConquer().value);
    }

    @Test
    public void performanceMergeSortThreadedDnC() {
        ArrayList<Integer> fullTestList = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            fullTestList.add(getRandomNumber(0, 500000));
        }

        ExecutionTimer<List<Integer>> result = new ExecutionTimer<>(() -> new MergeSortThreadedDnC(fullTestList.subList(0, 1000)).divideAndConquer().value);
        System.out.println("1'000 elements: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new MergeSortThreadedDnC(fullTestList.subList(0, 10000)).divideAndConquer().value);
        System.out.println("10'000 elements: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new MergeSortThreadedDnC(fullTestList.subList(0, 100000)).divideAndConquer().value);
        System.out.println("100'000 elements: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new MergeSortThreadedDnC(fullTestList.subList(0, 500000)).divideAndConquer().value);
        System.out.println("500'000 elements: " + result.getPrettyTime());
    }

    private int getRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}
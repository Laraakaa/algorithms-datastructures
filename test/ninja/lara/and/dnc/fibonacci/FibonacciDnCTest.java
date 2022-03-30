package ninja.lara.and.dnc.fibonacci;

import ninja.lara.and.measurement.ExecutionTimer;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciDnCTest {
    @Test
    public void doesFibonacciDnC() {
        Assert.assertEquals(0, new FibonacciDnC(0).divideAndConquer().value);
        Assert.assertEquals(1, new FibonacciDnC(1).divideAndConquer().value);
        Assert.assertEquals(1, new FibonacciDnC(2).divideAndConquer().value);
        Assert.assertEquals(2, new FibonacciDnC(3).divideAndConquer().value);
        Assert.assertEquals(3, new FibonacciDnC(4).divideAndConquer().value);
        Assert.assertEquals(5, new FibonacciDnC(5).divideAndConquer().value);

        Assert.assertEquals(55, new FibonacciDnC(10).divideAndConquer().value);
        Assert.assertEquals(610, new FibonacciDnC(15).divideAndConquer().value);
        Assert.assertEquals(6765, new FibonacciDnC(20).divideAndConquer().value);
    }

    @Test
    public void performanceFibonacciDnC() {
        ExecutionTimer<Integer> result = new ExecutionTimer<>(() -> new FibonacciDnC(20).divideAndConquer().value);
        System.out.println("20 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciDnC(30).divideAndConquer().value);
        System.out.println("30 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciDnC(40).divideAndConquer().value);
        System.out.println("40 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciDnC(43).divideAndConquer().value);
        System.out.println("43 time: " + result.getPrettyTime());
    }
}
package ninja.lara.and.dnc.fibonacci;

import ninja.lara.and.measurement.ExecutionTimer;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciMemoryDnCTest {
    @Test
    public void doesFibonacciMemoryDnC() {
        Assert.assertEquals(0, new FibonacciMemoryDnC(0).divideAndConquer().value);
        Assert.assertEquals(1, new FibonacciMemoryDnC(1).divideAndConquer().value);
        Assert.assertEquals(1, new FibonacciMemoryDnC(2).divideAndConquer().value);
        Assert.assertEquals(2, new FibonacciMemoryDnC(3).divideAndConquer().value);
        Assert.assertEquals(3, new FibonacciMemoryDnC(4).divideAndConquer().value);
        Assert.assertEquals(5, new FibonacciMemoryDnC(5).divideAndConquer().value);

        Assert.assertEquals(55, new FibonacciMemoryDnC(10).divideAndConquer().value);
        Assert.assertEquals(610, new FibonacciMemoryDnC(15).divideAndConquer().value);
        Assert.assertEquals(6765, new FibonacciMemoryDnC(20).divideAndConquer().value);
    }

    @Test
    public void performanceFibonacciMemoryDnC() {
        ExecutionTimer<Integer> result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(20).divideAndConquer().value);
        System.out.println("20 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(30).divideAndConquer().value);
        System.out.println("30 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(40).divideAndConquer().value);
        System.out.println("40 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(43).divideAndConquer().value);
        System.out.println("43 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(100).divideAndConquer().value);
        System.out.println("100 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(1000).divideAndConquer().value);
        System.out.println("1000 time: " + result.getPrettyTime());

        result = new ExecutionTimer<>(() -> new FibonacciMemoryDnC(3200).divideAndConquer().value);
        System.out.println("5000 time: " + result.getPrettyTime());
    }
}
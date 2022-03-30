package ninja.lara.and.dnc.fibonacci;

import ninja.lara.and.dnc.DivideAndConquerable;
import ninja.lara.and.dnc.output.IntegerOutput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FibonacciMemoryDnC implements DivideAndConquerable<IntegerOutput> {
    private final int i;
    private final HashMap<Integer, IntegerOutput> memory;

    public FibonacciMemoryDnC(int i, HashMap<Integer, IntegerOutput> memory) {
        this.i = i;
        this.memory = memory;
    }

    public FibonacciMemoryDnC(int i) {
        this.i = i;
        this.memory = new HashMap<>();
    }

    @Override
    public boolean isBasic() {
        return i <= 1;
    }

    @Override
    public IntegerOutput baseFun() {
        return new IntegerOutput(i);
    }

    @Override
    public List<FibonacciMemoryDnC> decompose() {
        return Arrays.asList(new FibonacciMemoryDnC(i - 2, memory), new FibonacciMemoryDnC(i - 1, memory));
    }

    @Override
    public IntegerOutput recombine(List<IntegerOutput> intermediateResults) {
        return new IntegerOutput(intermediateResults.get(0).value + intermediateResults.get(1).value);
    }

    @Override
    public IntegerOutput divideAndConquer() {
        // Check if output is cached
        if (memory.containsKey(i)) {
            return memory.get(i);
        }

        IntegerOutput result = DivideAndConquerable.super.divideAndConquer();

        // Cache result
        memory.put(i, result);
        return result;
    }
}

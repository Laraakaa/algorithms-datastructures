package ninja.lara.and.dnc.fibonacci;

import ninja.lara.and.dnc.DivideAndConquerable;
import ninja.lara.and.dnc.output.IntegerOutput;

import java.util.Arrays;
import java.util.List;

public class FibonacciDnC implements DivideAndConquerable<IntegerOutput> {
    private final int i;

    public FibonacciDnC(int i) {
        this.i = i;
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
    public List<FibonacciDnC> decompose() {
        return Arrays.asList(new FibonacciDnC(i - 2), new FibonacciDnC(i - 1));
    }

    @Override
    public IntegerOutput recombine(List<IntegerOutput> intermediateResults) {
        return new IntegerOutput(intermediateResults.get(0).value + intermediateResults.get(1).value);
    }
}

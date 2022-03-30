package ninja.lara.and.dnc;

import java.util.ArrayList;
import java.util.List;

public interface DivideAndConquerable<OutputType> {
    boolean isBasic();
    OutputType baseFun();
    List<? extends DivideAndConquerable<OutputType >> decompose();
    OutputType recombine(List <OutputType> intermediateResults);

    default List <? extends DivideAndConquerable<OutputType>> stump() {
        return new ArrayList<>(0);
    }

    default OutputType divideAndConquer() {
        if (this.isBasic()) return this.baseFun();

        List <? extends DivideAndConquerable<OutputType>> subcomponents = this.decompose();

        List <OutputType> intermediateResults = new ArrayList<>(subcomponents.size());
        subcomponents.forEach(subcomponent -> intermediateResults.add(subcomponent.divideAndConquer()));

        return recombine(intermediateResults);
    }
}

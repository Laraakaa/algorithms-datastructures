package ninja.lara.and.dnc;

import ninja.lara.and.threads.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface DivideAndConquerableThreaded<OutputType> extends DivideAndConquerable<OutputType> {
    @Override
    default OutputType divideAndConquer() {
        // System.out.println(Thread.activeCount());
        if (this.isBasic()) return this.baseFun();

        List<? extends DivideAndConquerable<OutputType>> subcomponents = this.decompose();

        List <OutputType> intermediateResults = new ArrayList<>(subcomponents.size());
        List<Future<OutputType>> futures = new ArrayList<>();
        subcomponents.forEach(subcomponent -> {
            if (getThreadPool().hasThreadAvailable()) {
                futures.add(getThreadPool().startThread(subcomponent::divideAndConquer));
            } else {
                intermediateResults.add(subcomponent.divideAndConquer());
            }
        });

        // Await futures
        for (Future<OutputType> future : futures) {
            try {
                intermediateResults.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return recombine(intermediateResults);
    }

    ThreadPool<OutputType> getThreadPool();
}

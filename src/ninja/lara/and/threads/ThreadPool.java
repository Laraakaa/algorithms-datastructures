package ninja.lara.and.threads;

import java.util.concurrent.*;

public class ThreadPool<ResultType> {
    private final ExecutorService executorService;
    private final int size;

    public ThreadPool(int size) {
        this.executorService = Executors.newFixedThreadPool(size);
        this.size = size;
    }

    public boolean hasThreadAvailable() {
        return Thread.activeCount() < size;
    }

    public Future<ResultType> startThread(Callable<ResultType> callable) {
        return executorService.submit(callable);
    }
}

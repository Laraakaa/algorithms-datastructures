package ninja.lara.and.dnc.mergesort;

import ninja.lara.and.dnc.DivideAndConquerableThreaded;
import ninja.lara.and.dnc.output.ListOutput;
import ninja.lara.and.threads.ThreadPool;

import java.util.Arrays;
import java.util.List;

public class MergeSortThreadedDnC extends MergeSortDnC implements DivideAndConquerableThreaded<ListOutput<Integer>> {
    private final ThreadPool<ListOutput<Integer>> threadPool;

    public MergeSortThreadedDnC(List<Integer> list) {
        super(list);
        this.threadPool = new ThreadPool<>(5);
    }

    public MergeSortThreadedDnC(List<Integer> list, ThreadPool<ListOutput<Integer>> threadPool) {
        super(list);
        this.threadPool = threadPool;
    }

    @Override
    public List<MergeSortDnC> decompose() {
        int mid = list.size() / 2;
        return Arrays.asList(new MergeSortThreadedDnC(list.subList(0, mid), threadPool), new MergeSortThreadedDnC(list.subList(mid, list.size()), threadPool));
    }

    @Override
    public ThreadPool<ListOutput<Integer>> getThreadPool() {
        return threadPool;
    }
}

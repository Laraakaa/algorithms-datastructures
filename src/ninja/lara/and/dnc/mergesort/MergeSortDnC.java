package ninja.lara.and.dnc.mergesort;

import ninja.lara.and.dnc.DivideAndConquerable;
import ninja.lara.and.dnc.output.IntegerOutput;
import ninja.lara.and.dnc.output.ListOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortDnC implements DivideAndConquerable<ListOutput<Integer>> {
    protected final List<Integer> list;

    public MergeSortDnC(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean isBasic() {
        return list.size() <= 2;
    }

    @Override
    public ListOutput<Integer> baseFun() {
        if (list.size() < 2) {
            return new ListOutput<>(new ArrayList<>(list));
        }

        int left = list.get(0);
        int right = list.get(1);

        if (left < right) {
            return new ListOutput<>(Arrays.asList(left, right));
        }
        return new ListOutput<>(Arrays.asList(right, left));
    }

    @Override
    public List<MergeSortDnC> decompose() {
        int mid = list.size() / 2;
        return Arrays.asList(new MergeSortDnC(list.subList(0, mid)), new MergeSortDnC(list.subList(mid, list.size())));
    }

    @Override
    public ListOutput<Integer> recombine(List<ListOutput<Integer>> intermediateResults) {
        List<Integer> listA = new ArrayList<>(intermediateResults.get(0).value);
        List<Integer> listB = new ArrayList<>(intermediateResults.get(1).value);
        List<Integer> result = new ArrayList<>();

        int size = listA.size() + listB.size();

        for (int i = 0; i < size; i++) {
            if (listA.size() == 0) {
                result.addAll(listB);
                break;
            }
            if (listB.size() == 0) {
                result.addAll(listA);
                break;
            }
            if (listA.get(0) < listB.get(0)) {
                result.add(listA.get(0));
                listA.remove(0);
                continue;
            }
            if (listB.get(0) < listA.get(0)) {
                result.add(listB.get(0));
                listB.remove(0);
                continue;
            }
            // Same elements
            result.addAll(Arrays.asList(listA.get(0), listB.get(0)));
            listA.remove(0);
            listB.remove(0);
        }
        return new ListOutput<>(result);
    }
}

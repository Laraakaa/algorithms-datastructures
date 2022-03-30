package ninja.lara.and.dnc.output;

import java.util.List;

public class ListOutput<T> {
    public List<T> value;

    public ListOutput(List<T> value) {
        this.value = value;
    }
}

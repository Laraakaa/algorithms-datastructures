package ninja.lara.and.measurement;

import java.time.Duration;
import java.util.function.Supplier;

public class ExecutionTimer<T> {
    public T result = null ;
    public long time = 0; // nanoseconds

    public ExecutionTimer(final Supplier<T> code) {
        System.gc(); // important !
        long start = System.nanoTime();
        this.result = code.get();
        long end = System.nanoTime();
        this.time = end - start;
    }

    public Duration getTimeDuration() {
        return Duration.ofNanos(time);
    }

    public String getPrettyTime() {
        Duration duration = getTimeDuration();
        return duration.toSeconds() + "." + String.format("%1$3s", duration.toMillisPart()).replace(' ', '0') + "s";
    }
}

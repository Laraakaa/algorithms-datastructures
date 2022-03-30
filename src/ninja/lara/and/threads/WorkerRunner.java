package ninja.lara.and.threads;

import java.util.concurrent.LinkedBlockingQueue;

public class WorkerRunner extends Thread {
    boolean isBusy = false;

    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            Runnable task;
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                    }
                }
                isBusy = true;
                task = queue.poll();
            }

            task.run();
            isBusy = false;
        }
    }

    public void doWork(Runnable runnable) {
        if (isBusy) {
            throw new RuntimeException("Worker can't take any work, it's busy!");
        }

        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }
}

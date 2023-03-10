package ua.khpi.oop.Dovhopolov13;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ParallelIteratorProcessor<T> {
    private final Iterator<T> iterator;
    private final ExecutorService executorService;
    private final long timeoutInMillis;

    public ParallelIteratorProcessor(Iterator<T> iterator, int numThreads, long timeoutInMillis) {
        this.iterator = iterator;
        this.executorService = Executors.newFixedThreadPool(numThreads);
        this.timeoutInMillis = timeoutInMillis;
    }

    public void process(Consumer<T> processor) throws InterruptedException {
        while (iterator.hasNext()) {
            T element = iterator.next();
            executorService.submit(() -> processor.accept(element));
        }
        executorService.shutdown();
        executorService.awaitTermination(timeoutInMillis, TimeUnit.MILLISECONDS);
    }

}



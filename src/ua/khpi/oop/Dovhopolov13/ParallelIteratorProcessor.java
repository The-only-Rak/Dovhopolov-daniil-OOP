package ua.khpi.oop.Dovhopolov13;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Класс ParallelIteratorProcessor предназначен для обработки итерируемой коллекции в многопоточном режиме.
 * @param <T> Тип элементов коллекции
 */
public class ParallelIteratorProcessor<T> {
    private final Iterator<T> iterator; // Итератор для обхода коллекции
    private final ExecutorService executorService; // Пул потоков для выполнения задач
    private final long timeoutInMillis; // Максимальное время ожидания завершения задач в пуле потоков
    private final Object lock = new Object(); // Объект-блокировка для синхронизации доступа к разделяемому ресурсу

    /**
     * Конструктор класса ParallelIteratorProcessor.
     * @param iterator Итератор для обхода коллекции
     * @param numThreads Количество потоков, которые будут использоваться для выполнения задач
     * @param timeoutInMillis Максимальное время ожидания завершения задач в пуле потоков
     */
    public ParallelIteratorProcessor(Iterator<T> iterator, int numThreads, long timeoutInMillis) {
        this.iterator = iterator;
        this.executorService = Executors.newFixedThreadPool(numThreads);
        this.timeoutInMillis = timeoutInMillis;
    }

    /**
     * Метод process предназначен для обработки элементов коллекции с помощью заданного обработчика.
     * @param processor Обработчик элементов коллекции. Принимает на вход элемент коллекции и объект-блокировку.
     *                 Обработчик должен быть потокобезопасным, т.е. гарантировать корректную работу при параллельном выполнении.
     * @throws InterruptedException Если задачи не удалось завершить за отведенное время.
     */
    public void process(BiConsumer<T,Object> processor) throws InterruptedException {
        while (iterator.hasNext()) {
            T element = iterator.next();
            executorService.submit(() -> processor.accept(element,lock));
        }
        executorService.shutdown();
        if(!executorService.awaitTermination(timeoutInMillis, TimeUnit.MILLISECONDS))
        	throw new InterruptedException();
    }
}


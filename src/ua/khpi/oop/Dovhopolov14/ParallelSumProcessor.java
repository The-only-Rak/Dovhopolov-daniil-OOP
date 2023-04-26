/**

This class extends the ParallelIteratorProcessor class to provide the functionality of
processing the sum of integers in parallel using multiple threads.
*/
package ua.khpi.oop.Dovhopolov14;
import java.util.Iterator;
import ua.khpi.oop.Dovhopolov10.Bus;

import ua.khpi.oop.Dovhopolov13.ParallelIteratorProcessor;

public class ParallelSumProcessor extends ParallelIteratorProcessor<Bus> {
	int res; // holds the computed sum

	/**
	 * Constructor to initialize ParallelSumProcessor object with given parameters.
	 * 
	 * @param iterator An iterator of integers to be processed in parallel.
	 * @param numThreads Number of threads to be used for parallel processing.
	 * @param timeoutInMillis Maximum time to wait for the threads to complete their tasks.
	 */
	public ParallelSumProcessor(Iterator<Bus> iterator, int numThreads, long timeoutInMillis) {
	    super(iterator, numThreads, timeoutInMillis);
	}

	/**
	 * Method to compute the sum of integers in parallel using the given number of threads.
	 * 
	 * @return The computed sum of integers.
	 * @throws InterruptedException If the threads are interrupted during the processing.
	 */
	public int sum() throws InterruptedException {
		this.process((Bus _bus, Object lock) -> {
			synchronized (lock) {
				
				this.res += _bus.getFreeSeats();
			}
		});
		return res;
	}

}

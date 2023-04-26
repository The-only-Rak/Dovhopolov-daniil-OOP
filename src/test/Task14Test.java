package test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;

import ua.khpi.oop.Dovhopolov10.Bus;
import ua.khpi.oop.Dovhopolov14.ParallelSumProcessor;
public class Task14Test {
	@org.junit.jupiter.api.Test
	public void Test1() throws InterruptedException
	{
		Bus[]arr = new Bus[5];
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Bus();
			arr[i].setFreeSeats(i);
		}
		ParallelSumProcessor parr = new ParallelSumProcessor(Arrays.asList(arr).iterator(), 2, 10000000);
		var res = parr.sum();
		assertEquals(res, 10);
	}
}

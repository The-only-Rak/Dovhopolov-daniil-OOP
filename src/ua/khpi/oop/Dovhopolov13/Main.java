package ua.khpi.oop.Dovhopolov13;


import java.util.Arrays;

public class Main {
	static Integer res = 0;
	public static void main(String[] args) throws InterruptedException {
		Integer[] randomArray = new Integer[10000];

		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = i;
		}
		 var pIP = new ParallelIteratorProcessor<Integer>(Arrays.asList(randomArray).iterator(),2,10000);
		 pIP.process((Integer i)->{
				 res += i;
		 });
		 System.out.println(res);
	}
}

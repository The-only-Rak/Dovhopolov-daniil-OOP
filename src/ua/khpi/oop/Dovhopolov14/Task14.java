package ua.khpi.oop.Dovhopolov14;
import ua.khpi.oop.Dovhopolov10.Bus;
import java.util.Arrays;
//Лаба 14 Multithreading. Ефективність використання
//Мета∗
//	Вимірювання часу паралельних та послідовних обчислень.
//  Демонстрація ефективності паралельної обробки.
//Організація паралельного виконання декількох частин програми
//Зробленно Довгополовом Даніїлом
public class Task14 {
	/**

	Класс Task14 представляет собой точку входа в программу, которая
	запускает процесс подсчета суммы элементов массива в несколько потоков.
	<p>В данной программе создается массив случайных целых чисел длиной 1000000 и запускается
	процесс подсчета суммы элементов массива в 10000 потоков с использованием класса
	ParallelSumProcessor, который наследуется от класса ParallelIteratorProcessor.
	Для этого создается объект ParallelSumProcessor, в котором передается итератор,
	размер пула потоков и максимальное время ожидания завершения всех потоков.
	Затем вызывается метод sum() у созданного объекта для подсчета суммы элементов массива.
	<p>Для проверки корректности результата в последовательном режиме вычисляется сумма элементов массива,
	и затем производится вывод в консоль времени выполнения каждого метода и соотношения времен
	выполнения в процентах.
	*/
	public static void main(String[] args) throws InterruptedException {
		Bus[] randomArray = new Bus[100000];
		
		
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = new Bus();
			randomArray[i].setFreeSeats(i);
		}
		
		ParallelSumProcessor par = new ParallelSumProcessor(Arrays.asList(randomArray).iterator(), 16, 1000000);
		long t1 = System.currentTimeMillis();
		par.sum();
		t1 = System.currentTimeMillis() - t1;
		long t2 = System.currentTimeMillis();
		@SuppressWarnings("unused")
		long[] res = new long[2];
		for (Bus i : randomArray) {
	    	var curr = i.getFreeSeats();
	    	if (curr > res[1])
	    	{
					res[1] = curr;
	    	}
	    	if(curr < res[0])
	    	{
					res[1] = curr;
	    	}
		}
		t2 = System.currentTimeMillis() - t2;
		System.out.println(String.format("t1 = %d, t2 = %d, %% = %f", t1,t2, (double)t1 / t2));

	}

}

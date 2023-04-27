package test;
import ua.khpi.oop.Dovhopolov10.Bus;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
public class Task11Test {
	@org.junit.jupiter.api.Test
	public void test1()
	{
		assertThrows(IllegalArgumentException.class,() ->{
			new Bus("12312");
		});

	}
	@org.junit.jupiter.api.Test
	public void test2()
	{
		assertThrows(NumberFormatException.class,() ->{
			new Bus("Gbdj 123 432 asdas");
		});
	}
	@org.junit.jupiter.api.Test
	public void test3()
	{
		assertThrows(DateTimeParseException.class,() ->{
			new Bus("123 321 3212 4343");
		});
	}
	@org.junit.jupiter.api.Test
	public void test4()
	{
	new Bus("123 "+"Киев-Львов "+LocalDateTime.now()+" 12");
	}
}

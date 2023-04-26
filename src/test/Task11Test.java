package test;
import ua.khpi.oop.Dovhopolov10.Bus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
public class Task11Test {
	@org.junit.jupiter.api.Test
	public void test1()
	{
		try
		{
		new Bus("12312");
		}
		catch (Exception e) {
			return;
		}
		assertEquals(false, true);
	}
	@org.junit.jupiter.api.Test
	public void test2()
	{
		try
		{
		new Bus("Gbdj 123 432 asdas");
		}
		catch (Exception e) {
			return;
		}
		assertEquals(false, true);
	}
	@org.junit.jupiter.api.Test
	public void test3()
	{
		try
		{
		new Bus("123 321 3212 4343");
		}
		catch (Exception e) {
			return;
		}
		assertEquals(false, true);
	}
	@org.junit.jupiter.api.Test
	public void test4()
	{
	new Bus("123 "+"Киев-Львов "+LocalDateTime.now()+" 12");
	}
}

package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import ua.khpi.oop.Dovhopolov09.LinkedListContainer;
import ua.khpi.oop.Dovhopolov10.Bus;
import ua.khpi.oop.Dovhopolov12.Task12;
public class Task12Test {
	@org.junit.jupiter.api.Test
	public void Test1()
	{
		String s =  "1-3-9";
		LinkedListContainer<Bus> buses = new LinkedListContainer<>();
		buses.add(new Bus(0,"1-3-6-8",LocalDateTime.of(2023, 04, 29, 8, 8, 8),0));
		buses.add(new Bus(1,"1-3-9",LocalDateTime.of(2023, 04, 29,8, 8, 8),0));
		buses.add(new Bus(2,"1-3-5-9",LocalDateTime.of(2023, 04, 29,8, 8, 8),0));
		buses.add(new Bus(3,"1-3-8-9",LocalDateTime.of(2023, 04, 29,8, 8, 8),0));
		buses.add(new Bus(4,"1-3-10-12-18-31-9",LocalDateTime.of(2023, 04, 29, 8, 8, 8),0));
		buses.add(new Bus(5,"1-14-15-19-3-9",LocalDateTime.of(2023, 04, 29, 8, 8, 8),0));
		buses.add(new Bus(6,"1-3-9",LocalDateTime.of(2023, 4, 27, 8, 8, 8),0));
		buses.add(new Bus(7,"1-3-6-9",LocalDateTime.of(2023,4, 27, 8, 8, 8),0));
		buses.add(new Bus(8,"1-2-3-6-9",LocalDateTime.of(2023, 4, 27, 8, 8, 8),0));
		buses.add(new Bus(9,"1-3-6-8",LocalDateTime.of(2023, 4, 27, 8, 8, 8),0));
		var res = Task12.filtrDist(s, buses);
		assertEquals(
				"""	
				[id= 1, destination= 1-3-9 , departureTime= 2023-04-29T08:08:08 , freeSeats= 0,
				id= 2, destination= 1-3-5-9 , departureTime= 2023-04-29T08:08:08 , freeSeats= 0,
				id= 3, destination= 1-3-8-9 , departureTime= 2023-04-29T08:08:08 , freeSeats= 0,
				id= 4, destination= 1-3-10-12-18-31-9 , departureTime= 2023-04-29T08:08:08 , freeSeats= 0,
				id= 5, destination= 1-14-15-19-3-9 , departureTime= 2023-04-29T08:08:08 , freeSeats= 0]""", res.toString());
		
	}
}

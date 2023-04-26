package ua.khpi.oop.Dovhopolov10;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

/**

This class represents a Bus object.

A Bus object contains an ID, destination, departure time and number of free seats.
 */
public class Bus {
	private int id;
	private String destination;
	private	LocalDateTime departureTime;
	private int freeSeats;

	/**

Constructs a Bus object with the given ID, destination, departure time and number of free seats.
@param id The ID of the bus.
@param destination The destination of the bus.
@param departureTime The departure time of the bus.
@param freeSeats The number of free seats on the bus.
	 */
	public Bus() {
		this.id = 0;
		this.destination = new String();
		this.departureTime =LocalDateTime.MIN;
		this.freeSeats = 0;
	}
	public Bus(int id, String destination, LocalDateTime departureTime, int freeSeats) {
		this.id = id;
		this.destination = destination;
		this.departureTime = departureTime;
		this.freeSeats = freeSeats;
	}
	public Bus(String str)
	{
		var patern = Pattern.compile("(?<id>\\d+) (?<destination>[\\S-]+) (?<departureTime>\\S+) (?<freeSeats>\\d+)");
		var mathes = patern.matcher(str);
		if(!mathes.find())
		{
			throw new IllegalArgumentException();
		}
		// Create new bus object and add it to the list
		this.id = Integer.parseInt(mathes.group("id"));
		this.destination = mathes.group("destination");
		this.departureTime = LocalDateTime.parse(mathes.group("departureTime"));
		this.freeSeats =  Integer.parseInt(mathes.group("freeSeats"));
	}
	/**

Returns the ID of the bus.
@return The ID of the bus.
	 */
	public int getId() {
		return id;
	}
	/**

Sets the ID of the bus.
@param id The ID to set for the bus.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**

Returns the destination of the bus.
@return The destination of the bus.
	 */
	public String getDestination() {
		return destination;
	}
	/**

Sets the destination of the bus.
@param destination The destination to set for the bus.
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**

Returns the departure time of the bus.
@return The departure time of the bus.
	 */
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	/**

Sets the departure time of the bus.
@param departureTime The departure time to set for the bus.
	 */
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	/**

Returns the number of free seats on the bus.
@return The number of free seats on the bus.
	 */
	public int getFreeSeats() {
		return freeSeats;
	}
	/**

Sets the number of free seats on the bus.
@param freeSeats The number of free seats to set for the bus.
	 */
	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}
	/**

Returns a string representation of the Bus object.
@return A string representation of the Bus object.
	 */
	@Override
	public String toString() {
		return 
				"id= " + id +
				", destination= " + destination + ' ' +
				", departureTime= " + departureTime.toString() + ' ' +
				", freeSeats= " + freeSeats 
				;
	}
}
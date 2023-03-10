package ua.khpi.oop.Dovhopolov10;

import java.util.Comparator;
import ua.khpi.oop.Dovhopolov09.*;
/**The BusStation class provides methods for sorting a list of Bus objects by id, departure time, and number of free seats.
 */
public class BusStation {
	/**
	 * Sorts a list of Bus objects by id.
	 *
	 * @param list the LinkedListContainer of Bus objects to be sorted
	 * @param <T>  the type of Bus object
	 */
	public static <T extends Bus> void sortById(LinkedListContainer<T> list) {

		list.sort(Comparator.comparingInt(Bus::getId));
	}
	/**
	 * Sorts a list of Bus objects by departure time.
	 *
	 * @param list the LinkedListContainer of Bus objects to be sorted
	 * @param <T>  the type of Bus object
	 */
	public static <T extends Bus> void sortByDepartureTime(LinkedListContainer<T> list) {
		list.sort(Comparator.comparing(Bus::getDepartureTime));
	}


	/**
	 * Sorts a list of Bus objects by number of free seats.
	 *
	 * @param list the LinkedListContainer of Bus objects to be sorted
	 * @param <T>  the type of Bus object
	 */
	public static <T extends Bus> void sortByFreeSeats(LinkedListContainer<T> list) {
		list.sort(Comparator.comparingInt(Bus::getFreeSeats));
	}
}
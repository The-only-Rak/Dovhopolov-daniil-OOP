package ua.khpi.oop.Dovhopolov11;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import ua.khpi.oop.Dovhopolov09.*;
import ua.khpi.oop.Dovhopolov10.*;
//Лаба 11 Регулярні вирази. Перевірка даних
//Мета∗
//	Ознайомлення з принципами використання регулярних виразів для перевірки рядка на відповідність шаблону.
//Зробленно Довгополовом Даніїлом
public class Task11 {
	/**
	 * Generates a linked list of randomly generated buses.
	 * 
	 * @param n the number of buses to generate
	 * @return a linked list of randomly generated buses
	 */
	public static LinkedListContainer<Bus> generateBuses(int n) {
		LinkedListContainer<Bus> buses = new LinkedListContainer<>();
		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			int id = rand.nextInt(1000);
			String destination = "Destination " + id;
			String departureTime = String.format("%02d:%02d", rand.nextInt(24), rand.nextInt(60));
			int freeSeats = rand.nextInt(50);

			Bus bus = new Bus(id, destination, departureTime, freeSeats);
			buses.add(bus);
		}

		return buses;
	}
	/**
	 * The main method for the Bus Station program.
	 * 
	 * @param args the command line arguments (not used in this program)
	 */
	public static void main(String[] args) {

		// Create empty list of buses
		LinkedListContainer<Bus> buses = new LinkedListContainer<>();
		if (args.length == 0)
		{
			Scanner scanner = new Scanner(System.in);
			// Menu for the user
			while (true) {
				System.out.println("1. Add bus");
				System.out.println("2. Sort by bus id");
				System.out.println("3. Sort by departure time");
				System.out.println("4. Sort by free seats");
				System.out.println("5. Load from file");
				System.out.println("6. Exit");

				// Get user choice
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();

				// Process user choice
				switch (choice) {
				case 1:
					System.out.print("Enter bus in form {id destination departureTime freeSeats}");
					var str = scanner.next() + scanner.nextLine();
					var patern = Pattern.compile("(?<id>\\d+) (?<destination>\\S+) (?<departureTime>\\S+) (?<freeSeats>\\d+)");
					var mathes = patern.matcher(str);
					if(!mathes.find())
					{
						throw new IllegalArgumentException();
					}
					// Create new bus object and add it to the list
					Bus bus = new Bus(Integer.parseInt(mathes.group("id")), mathes.group("destination"),mathes.group("departureTime") ,Integer.parseInt(mathes.group("freeSeats")) );
					buses.add(bus);
					break;
				case 2:
					// Sort buses by id and print the sorted list
					BusStation.sortById(buses);
					System.out.println(buses);
					break;
				case 3:
					// Sort buses by departure time and print the sorted list
					BusStation.sortByDepartureTime(buses);
					System.out.println(buses);
					break;
				case 4:
					// Sort buses by number of free seats and print the sorted list
					BusStation.sortByFreeSeats(buses);
					System.out.println(buses);
					break;
				case 5:
					// Create many new buses object from file and add it to the list
					String content = "";
					System.out.print("Enter file name: ");
					var fileName = scanner.next();
			        try {
			            content = Files.readString(Paths.get(fileName));
			            System.out.println("File content: \n" + content);
			        } catch (IOException e) {
			            System.err.println("Error reading file: " + e.getMessage());
			        }
					var _patern = Pattern.compile("(?<id>\\d+) (?<destination>\\S+) (?<departureTime>\\S+) (?<freeSeats>\\d+)");
					var _mathes = _patern.matcher(content);
					while(_mathes.find())
					{
						Bus _bus = new Bus(Integer.parseInt(_mathes.group("id")), _mathes.group("destination"),_mathes.group("departureTime") ,Integer.parseInt(_mathes.group("freeSeats")) );
						buses.add(_bus);
					}
					break;
				case 6:
					// Exit the program
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");
				}
			}

		}
		else
		{
			buses = generateBuses(10);

			System.out.println("Unsorted list of buses:");
			System.out.println(buses);

			BusStation.sortById(buses);

			System.out.println("Sorted list of buses by id:");
			System.out.println(buses);
		}
	}	
}

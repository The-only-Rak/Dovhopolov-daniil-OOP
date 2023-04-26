package ua.khpi.oop.Dovhopolov15;

import java.io.IOException;
//Лаба 15 Колекції в Java∗
//Мета∗
//	Ознайомлення з бібліотекою колекцій Java SE.
//  Використання колекцій для розміщення об'єктів розроблених класів.
//Зробленно Довгополовом Даніїлом
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import ua.khpi.oop.Dovhopolov09.*;
import ua.khpi.oop.Dovhopolov10.*;
//The following Java code implements a program for a bus station. It generates and maintains a list of buses. The program allows the user to add a bus, sort the list of buses by different criteria, load a list of buses from a file, and filter the list of buses by destination.
//
//The program starts by defining a class named Task15. The class contains two static methods: generateBuses and main. The generateBuses method generates a list of buses by creating a specified number of random buses. The main method is the entry point for the program. It creates an empty list of buses and displays a menu of options to the user.
//
//The user can choose to add a bus to the list, sort the list by bus ID, sort the list by departure time, sort the list by number of free seats, load a list of buses from a file, filter the list by destination, or exit the program. The user's input is read using a Scanner object.
//
//When the user chooses to add a bus to the list, the program prompts the user to enter the bus information in the form "id destination departureTime freeSeats". It then parses the input using a regular expression pattern and creates a new bus object. The new bus object is added to the list of buses.
//
//When the user chooses to sort the list by bus ID, the program uses the Comparator.comparingInt method to sort the list by bus ID and displays the sorted list to the user.
//
//When the user chooses to sort the list by departure time, the program uses the Comparator.comparing method to sort the list by departure time and displays the sorted list to the user.
//
//When the user chooses to sort the list by number of free seats, the program uses the Comparator.comparingInt method to sort the list by number of free seats and displays the sorted list to the user.
//
//When the user chooses to load a list of buses from a file, the program prompts the user to enter the file name. It then reads the content of the file and parses it using a regular expression pattern. The program creates a new bus object for each line in the file that matches the pattern and adds the new bus object to the list of buses.
//
//When the user chooses to filter the list by destination, the program prompts the user to enter the destination criteria in the form "dist1-dist2-dist3 ...". The program uses a regular expression pattern to match each bus destination to the criteria and displays the matching buses to the user.
//
//Finally, when the user chooses to exit the program, the program terminates.
public class Task15 {
	/**
	 * Generates a linked list of randomly generated buses.
	 * 
	 * @param n the number of buses to generate
	 * @return a linked list of randomly generated buses
	 */
	public static ArrayList<Bus> generateBuses(int n) {
		ArrayList<Bus> buses = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			int id = rand.nextInt(1000);
			String destination = "Destination " + id;
			String departureTime = String.format("%02d:%02d", rand.nextInt(24), rand.nextInt(60));
			int freeSeats = rand.nextInt(50);

			Bus bus = new Bus(id, destination, LocalDateTime.parse(departureTime), freeSeats);
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
		ArrayList<Bus> buses = new ArrayList<>();
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
				System.out.println("6. Filter by destination");
				System.out.println("7. Exit");

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
					Bus bus = new Bus(Integer.parseInt(mathes.group("id")), mathes.group("destination"),LocalDateTime.parse(mathes.group("departureTime")) ,Integer.parseInt(mathes.group("freeSeats")) );
					buses.add(bus);
					break;
				case 2:
					// Sort buses by id and print the sorted list
					buses.sort(Comparator.comparingInt(Bus::getId));
					System.out.println(buses);
					break;
				case 3:
					// Sort buses by departure time and print the sorted list
					buses.sort(Comparator.comparing(Bus::getDepartureTime));
					System.out.println(buses);
					break;
				case 4:
					// Sort buses by number of free seats and print the sorted list
					buses.sort(Comparator.comparingInt(Bus::getFreeSeats));
					System.out.println(buses);
					break;
				case 5:
					// Create many new buses object from file and add it to the list
					String content = "";
					System.out.print("Enter file name: ");
					var fileName = scanner.next();
			        try {
			            content = Files.readString(Paths.get(fileName));
			            System.out.println("File content: " + content);
			        } catch (IOException e) {
			            System.err.println("Error reading file: " + e.getMessage());
			        }
					var _patern = Pattern.compile("(?<id>\\d+) (?<destination>\\S+) (?<departureTime>\\S+) (?<freeSeats>\\d+)\n");
					var _mathes = _patern.matcher(content);
					while(_mathes.find())
					{
						Bus _bus = new Bus(Integer.parseInt(_mathes.group("id")), _mathes.group("destination"),LocalDateTime.parse(_mathes.group("departureTime")) ,Integer.parseInt(_mathes.group("freeSeats")) );
						buses.add(_bus);
					}
					break;
				case 6:
					// Sort buses by number of free seats and print the sorted list
					System.out.println("Enter what destination should be in way {dist1-dist2-dist3 ...}");
					var s = scanner.next();
					var count =  Pattern.compile("-").matcher(s).results().count();
					var pat = Pattern.compile(String.format("(%s)", s.trim().replaceAll("-", "|")));
					for (var i : buses) {
						var res = pat.matcher(i.getDestination()).results().count() == count + 1;
						if(res)
						{
							System.out.println(i);
						}
					}
					break;
				case 7:
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

			buses.sort(Comparator.comparingInt(Bus::getId));

			System.out.println("Sorted list of buses by id:");
			System.out.println(buses);
		}
	}	
}
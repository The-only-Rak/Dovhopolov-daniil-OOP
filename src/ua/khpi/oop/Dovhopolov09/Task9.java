package ua.khpi.oop.Dovhopolov09;

// Лаба 9 Параметризація в Java
//Мета∗
//	Вивчення принципів параметризації в Java.
//	Розробка параметризованих класів та методів.
//Зробленно Довгополовом Даніїлом

/**


This class represents an example of using the LinkedListContainer class.

It creates a new LinkedListContainer object, adds and removes elements,

clears the container, and checks if it is empty.
 */
public class Task9 {

	/**

Main method that creates a LinkedListContainer object, adds and removes elements,

clears the container, and checks if it is empty.
	 */
	public static void main(String[] args) {
		// create a new LinkedListContainer object
		LinkedListContainer<Integer> cont = new LinkedListContainer<>();

		// add elements to the container
		cont.add(12);
		cont.add(25);

		// remove an element from the container
		cont.remove(12);

		// print the container
		System.out.println(cont.toString());

		// clear the container
		cont.clear();

		// add elements to the container
		cont.add(25);
		cont.add(25);
		cont.add(25);
		cont.add(25);

		// print the container
		System.out.println(cont.toString());

		// clear the container
		cont.clear();

		// check if the container is empty
		System.out.println(cont.isEmpty());
	}

}

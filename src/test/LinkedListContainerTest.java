package test;
import ua.khpi.oop.Dovhopolov09.LinkedListContainer;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Assertions;


public class LinkedListContainerTest{

	@org.junit.jupiter.api.Test
    public void LinkedListContainer() {
		new LinkedListContainer<Integer>();
    }
    /**

    Returns the number of elements in the linked list.
    */
	@org.junit.jupiter.api.Test
    public void size() {
        var tmp = new LinkedListContainer<Integer>();
        assertEquals(tmp.size(), 0);
        tmp.add(123);
        assertEquals(tmp.size(), 1);
        
    }
    /**

    Checks whether the linked list is empty.
    */
	@org.junit.jupiter.api.Test
    public void isEmpty() {
    	var tmp = new LinkedListContainer<Integer>();
    	assertEquals(tmp.isEmpty(), true);
        tmp.add(123);
        assertEquals(tmp.isEmpty(), false);
    }
    /**

    Adds an element to the beginning of the linked list.
    @param element the element to add
    */
	@org.junit.jupiter.api.Test
    public void add() {
        var tmp = new LinkedListContainer<Integer>();
        tmp.add(123);
        assertEquals(tmp.contains(123), true);
    }
    /**

    Removes the first occurrence of the specified element from the linked list.
    @param element the element to remove
    */
	@org.junit.jupiter.api.Test
    public void remove() {
        var tmp = new LinkedListContainer<Integer>();
        tmp.add(123);
        assertEquals(tmp.contains(123), true);
        tmp.remove(123);
        assertEquals(tmp.contains(123), false);
    }
    /**

    Removes all elements from the linked list.
    */
	@org.junit.jupiter.api.Test
    public void clear() {
        var tmp = new LinkedListContainer<Integer>();
        tmp.add(123);
        tmp.clear();
        assertEquals(tmp.size(), 0);
    }
    /**

    Returns an array containing all of the elements in the linked list

    in the same order.

    @param a the array to store the elements in

    @return an array containing all of the elements in the linked list
    */
	@org.junit.jupiter.api.Test
    @SuppressWarnings("unchecked")
	public void toArray() {
    	var tmp = new LinkedListContainer<Integer>();
    	tmp.add(1);
    	tmp.add(1);
    	tmp.add(1);
    	assertArrayEquals(tmp.toArray(new Integer[3]), new Integer[] {1,1,1});
    }
    /**

    Returns a string representation of the linked list.
    */
	@org.junit.jupiter.api.Test
    public void String() {
    	var tmp = new LinkedListContainer<Integer>();
    	tmp.add(1);
    	tmp.add(1);
    	tmp.add(1);
    	assertEquals(tmp.toString(), "[1,\n1,\n1]");
    }
    /**

    Checks whether the linked list contains the specified element.
    @param element the element to check for
    @return true if the linked list contains the element, false otherwise
    */
	@org.junit.jupiter.api.Test
    public void contains() {
        var tmp = new LinkedListContainer<Integer>();
        assertEquals(tmp.contains(123), false);
        tmp.add(123);
        assertEquals(tmp.contains(123), true);

    }
   
 /** Sorts the elements in this LinkedListContainer using the specified Comparator.
  The sort is performed in place, modifying the current LinkedListContainer instance.  */
	@org.junit.jupiter.api.Test
    @SuppressWarnings("unchecked")
	public void sort() {
    	var tmp = new LinkedListContainer<Integer>();
    	tmp.add(3);
    	tmp.add(2);
    	tmp.add(1);
    	tmp.sort(Comparator.comparingInt(Integer::intValue).reversed());
    	assertArrayEquals(tmp.toArray(new Integer[3]), new Integer[] {1,2,3});

    }
}

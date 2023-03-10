package ua.khpi.oop.Dovhopolov09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**

A container class that implements a singly-linked list.

@param <T> the type of the elements in the container
*/
public class LinkedListContainer<T> implements Iterable<T>, Serializable {
	
	
    private ListNode<T> head;
    private int size;
    /**

    Constructs an empty linked list.
    */
    public LinkedListContainer() {
        this.head = null;
        this.size = 0;
    }
    /**

    Returns the number of elements in the linked list.
    @return the number of elements in the linked list
    */
    public int size() {
        return size;
    }
    /**

    Checks whether the linked list is empty.
    @return true if the linked list is empty, false otherwise
    */
    public boolean isEmpty() {
        return head == null;
    }
    /**

    Adds an element to the beginning of the linked list.
    @param element the element to add
    */
    public void add(T element) {
        ListNode<T> newNode = new ListNode<>(element);
        newNode.setNext(head);
        head = newNode;
        size++;
    }
    /**

    Removes the first occurrence of the specified element from the linked list.
    @param element the element to remove
    @return true if the element was removed, false otherwise
    */
    public boolean remove(T element) {
        ListNode<T> curr = head;
        ListNode<T> prev = null;
        while (curr != null) {
            if (curr.getData().equals(element)) {
                if (prev == null) {
                    head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }
    /**

    Removes all elements from the linked list.
    */
    public void clear() {
        head = null;
        size = 0;
    }
    /**

    Returns an array containing all of the elements in the linked list

    in the same order.

    @param a the array to store the elements in

    @return an array containing all of the elements in the linked list
    */
    @SuppressWarnings("unchecked")
	public T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (ListNode<T> x = head; x != null; x = x.getNext()) {
            result[i++] = x.getData();
        }

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }
    /**

    Returns a string representation of the linked list.
    @return a string representation of the linked list
    */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode<T> x = head; x != null; x = x.getNext()) {
            sb.append(x.getData().toString());
            if (x.getNext() != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    /**

    Checks whether the linked list contains the specified element.
    @param element the element to check for
    @return true if the linked list contains the element, false otherwise
    */
    public boolean contains(T element) {
        for (ListNode<T> x = head; x != null; x = x.getNext()) {
            if (x.getData().equals(element)) {
                return true;
            }
        }
        return false;
    }
    private class LinkedListContainerIterator<E> implements Iterator<E> {
        private ListNode<E> current;

        public LinkedListContainerIterator(ListNode<E> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E item = current.getData();
            current = current.getNext();
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<T> iterator() {
        return new LinkedListContainerIterator<T>(head);
    }
 /**
    Saves this LinkedListContainer to a file using object serialization.
 The filename parameter specifies the name of the file to save to.
  */
    public void save(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Collection saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** method for restoring the collection using serialization  */
    @SuppressWarnings("unchecked")
	public static <T> LinkedListContainer<T> restore(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        	LinkedListContainer<T> container = (LinkedListContainer<T>) ois.readObject();
            System.out.println("Collection restored from " + filename);
            return container;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    /* Saves this LinkedListContainer to a file using text serialization.
  The filename parameter specifies the name of the file to save to. */
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (T element : this) {
                writer.println(element.toString());
            }
            System.out.println("Collection saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 /** Sorts the elements in this LinkedListContainer using the specified Comparator.
  The sort is performed in place, modifying the current LinkedListContainer instance.  */
    @SuppressWarnings("unchecked")
	public void sort(Comparator<T> comparator) {
        // Convert the linked list to an array
        T[] array = toArray((T[]) new Object[size]);

        // Sort the array using the comparator
        Arrays.sort(array, comparator);

        // Clear the linked list
        clear();

        // Add the elements from the sorted array back into the linked list
        for (T element : array) {
            add(element);
        }
    }

}
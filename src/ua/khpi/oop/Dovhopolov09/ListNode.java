package ua.khpi.oop.Dovhopolov09;

/**

Represents a node in a singly-linked list.

@param <T> the type of data stored in the node
 */
public class ListNode<T> {
	private T data; // the data stored in the node
	private ListNode<T> next; // the next node in the list

	/**

Constructs a new ListNode object with the specified data.
@param data the data to store in the node
	 */
	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}
	/**

Returns the data stored in the node.
@return the data stored in the node
	 */
	public T getData() {
		return data;
	}
	/**

Returns the next node in the list.
@return the next node in the list
	 */
	public ListNode<T> getNext() {
		return next;
	}
	/**

Sets the next node in the list.
@param next the next node in the list
	 */
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
}

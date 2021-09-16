/**
 * My own Generic Linked List code from CSCE 145 (maybe it was 146 i dont remember at this point)
 * with a remove function added so that it functions as a queue. This code is really, really bad.
 * I had no clue back in my algorithms class that this was so bad, I mean there are unfinished
 * functions, the "previous" gets left all over the place, it doesn't even implement Iterable.
 * Whatever, it works. For now.
 */
package observer;

public class GenLL <T>{
	private class ListNode
	{
		private ListNode link;
		private T data;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //Points to first element in the list
	private ListNode current; //Current node of interest used externally
	private ListNode previous; //One node behind current
	
	public GenLL()
	{
		head = current = previous = null;
	}
	
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if (head == null)
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while (temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	
	public void insertAfterCurrent(T aData)
	{
		if (current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		if (current != null && previous == null) //At the head
		{
			head.link = newNode; //current.link = newNode;
		}
		else if (current != null && previous == null) //In the middle
		{
			current.link = newNode;
		}
	}
	
	public void print()
	{
		for (ListNode temp = head; temp != null; temp = temp.link) //Important implementation of for loop
			System.out.println(temp.data);
	}
	
	public T getCurrent()
	{
		if (current == null)
			return null;
		else
			return current.data;
	}
	
	public void setCurrent(T aData)
	{
		if (current == null)
			return;
		else
			current.data = aData;
	}
	
	public void iterate() //AKA gotoNext() or moveCurrentForward()
	{
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}
	
	public void resetCurrent()
	{
		current = head;
	}
	
	public boolean moreToIterate()
	{
		return current != null;
	}
	
	public void deleteCurrent()
	{
		if (current == null)
			return;
		if (current == head)
		{
			head = current = head.link; //current = current.link;
			return;
		}
		previous.link = current.link;
		current = current.link;
	}
	
	public void moveToIndex(int anIndex)
	{
		current = head;
		for (int i = 0; i<anIndex; i++)
			iterate();
	}
	
	public void delete(T aData) //MONKAS
	{
		ListNode temp = head;
		while (temp != null)
		{
			if (temp.link.data.equals(aData))
			{
				temp.link = temp.link.link;
				break;
			}
			temp = temp.link;
		}
	}

	public void remove() {
		head = head.link;
	}

	public int length() {
		int length = 0;
		current = head;
		while(current != null) {
			length++;
			iterate();
		}
		return length;
	}
}

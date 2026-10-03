//written by Dominic Mattio :)

public class DoubleDoubleLL  
{

	protected class ListNode //same as our usual ListNode class but with the added before-link
	{
		double data;
		ListNode link;
		ListNode bLink;
		
		public ListNode(double aData, ListNode aLink, ListNode aBl) 
		{
			data = aData;
			link = aLink;
			bLink = aBl;
		}
	}
	ListNode head;
	ListNode tail;
	ListNode current;
		
	public DoubleDoubleLL() 
	{
		head = tail = current = null;
	}
	
	public void add(double aData) //always write the add method first
	{
		ListNode newNode = new ListNode(aData, null, null);
		if(head == null)
		{
			head = tail = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) 
		{
			temp = temp.link;
		}	
		temp.link = newNode;
		newNode.bLink = temp;
		tail = newNode;
	}
	public void print() //always write the print method second
	{
		ListNode temp = head;
		while(temp != null) 
		{
			System.out.println(temp.data);
			temp = temp.link;
			
		}
	}
	public void addAfterCurrent(double aData) 
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData,current.link,current);
		if(current.link != null)
			current.link.bLink = newNode;
		current.link = newNode;
	}
	public void gotoNext() 
	{
		if(current != null)
			current = current.link;
	}
	public void gotoPrev()
	{
		if(current != null) 
			current = current.bLink;
	}
	public void reset() 
	{
		current = head;
	}
	public void gotoEnd() 
	{
		current = tail;
	}
	public boolean hasMore() 
	{
		if(current == null)
			return false;
		else
			return true;
	}
	public Double getCurrent() 
	{
		if(current == null)
			return null;
		return current.data;
	}
	public void setCurrent(double aData) 
	{
		if(current == null)
			return;
		current.data = aData;
	}
	public void remove(double aData) 
	{
		ListNode temp = head;
		while(temp.link != null) 
		{
			if(temp.data == aData) 
			{
				temp.bLink.link = temp.link;
				temp = temp.link;
			}
			temp = temp.link;
		}
		
	}
	public void removeCurrent() 
	{
		if(current == null)
			return;
		if(current.bLink != null)
			current.bLink.link = current.link;
		if(current == tail)//I realized this is why the last element wasn't printing correctly
			tail = tail.bLink;
		current = current.link;
	}
	public boolean contains(double aData) 
	{
		ListNode temp = head;
		while(temp != null) 
		{
			if(temp.data == aData)
				return true;
			temp = temp.link;
		}
		return false;
			
	}
	
	
}

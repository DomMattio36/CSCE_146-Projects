// written by Dominic Mattio :)
public class GroceryList
{
    // Each node stores one grocery item and a link to the next node.
    protected class ListNode
    {
        GroceryItem data;
        ListNode link;

        public ListNode()
        {
            data = null;
            link = null;
        }

        public ListNode(GroceryItem aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }

    // These references keep track of the first, current, and prior nodes.
    protected ListNode head;
    protected ListNode current;
    protected ListNode previous;

    public GroceryList()
    {
        // The list begins with the required empty head node.
        head = new ListNode();
        current = head;
        previous = head;
    }

    public void gotoNext()
    {
        // Do not move past the final node in the list.
        if(current != null && current.link != null)
        {
            previous = current;
            current = current.link;
        }
    }

    public GroceryItem getCurrent()
    {
        if(current == null)
            return null;
        return current.data;
    }

    public void setCurrent(GroceryItem aData)
    {
        if(current != null && aData != null)
            current.data = aData;
    }

    public void addItem(GroceryItem aData)
    {
        if(aData == null)
            return;

        // The first item fills the empty head node.
        if(head.data == null)
        {
            head.data = aData;
            return;
        }

        ListNode temp = head;
        while(temp.link != null)
            temp = temp.link;
        temp.link = new ListNode(aData, null);
    }

    public void addItemAfterCurrent(GroceryItem aData)
    {
        if(aData == null || current == null || head.data == null)
            return;

        current.link = new ListNode(aData, current.link);
    }

    public void removeCurrent()
    {
        if(current == null || head.data == null)
            return;

        // Removing the first item requires updating head itself.
        if(current == head)
        {
            if(head.link == null)
            {
                head.data = null;
                current = head;
                previous = head;
            }
            else
            {
                head = head.link;
                current = head;
                previous = head;
            }
        }
        else
        {
            previous.link = current.link;
            current = previous.link;
        }
    }

    public void showList()
    {
        ListNode temp = head;
        while(temp != null && temp.data != null)
        {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    public boolean contains(GroceryItem aData)
    {
        if(aData == null)
            return false;

        ListNode temp = head;
        while(temp != null && temp.data != null)
        {
            if(temp.data.equals(aData))
                return true;
            temp = temp.link;
        }
        return false;
    }

    public double totalCost()
    {
        double total = 0.0;
        ListNode temp = head;
        while(temp != null && temp.data != null)
        {
            total += temp.data.getValue();
            temp = temp.link;
        }
        return total;
    }
}

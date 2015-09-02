package collection.datastructures;

public class LinkedList
{
	private int size;

	public ListNode head;

	public LinkedList()
	{
		size = 0;
		head = new ListNode(-1);
		head.next = null;
	}

	public LinkedList add(int data) {
		ListNode node = new ListNode(data);
		add(node);
		return this;
	}
	
	public LinkedList add(ListNode node)
	{
		ListNode it = head;
		while (it.next != null)
			it = it.next;

		it.next = node;
		node.next = null;
		size++;
		return this;
	}

	public LinkedList remove()
	{
		if (size == 1)
		{
			head.next = null;
		}
		else
		{
			head.next = head.next.next;
		}
		size--;
		return this;
	}

	public LinkedList add(int pos, ListNode node)
	{
		if (pos > size + 1)
		{
			System.out.println("CANNAE");
			return this;
		}
		if (pos == 1)
		{
			node.next = head.next;
			head.next = node;
		}
		else
		{
			ListNode it = head;
			for (int index = 1; index < pos; index++)
			{
				it = it.next;
			}
			node.next = it.next;
			it.next = node;
		}
		size++;
		return this;
	}

	public LinkedList remove(int pos)
	{
		if (pos > size)
		{
			System.out.println("CANNAE");
			return this;
		}
		if (pos == 1)
		{
			head.next = head.next.next;
		}
		else
		{
			ListNode it = head;
			for (int index = 1; index < pos; index++)
			{
				it = it.next;
			}
			it.next = it.next.next;
		}
		size--;
		return this;
	}

	public LinkedList sortedInsert(ListNode node)
	{
		ListNode it = head.next;
		int pos = 1;
		while (it != null && it.data < node.data)
		{
			it = it.next;
			pos++;
		}
		return add(pos, node);
	}

	public LinkedList insertionSort()
	{
		LinkedList sorted = new LinkedList();
		ListNode it = head.next;
		for (int index = 1; index <= size && it != null; index++)
		{
			sorted.sortedInsert(new ListNode(it.data));
			it = it.next;
		}

		return sorted;
	}

	public LinkedList append(LinkedList another)
	{
		if (size == 0)
		{
			head=another.head;
		}
		else
		{
			ListNode it = head;
			while (it.next != null)
			{
				it = it.next;
			}

			it.next = another.head.next;
			size += another.size;
		}
		another.clear();
		return this;
	}

	public void split(LinkedList firstHalf, LinkedList secondHalf)
	{
		ListNode it = head.next;
		int itemNumber = 1;
		while (itemNumber <= size / 2)
		{
			firstHalf.add(new ListNode(it.data));
			it = it.next;
			itemNumber++;
		}

		while (itemNumber <= size)
		{
			secondHalf.add(new ListNode(it.data));
			it = it.next;
			itemNumber++;
		}

		firstHalf.print();
		secondHalf.print();
	}

	public LinkedList removeDuplicates()
	{
		if (size == 1)
			return this;
		else if (size == 2)
		{
			if (head.next.data == head.next.next.data)
				return remove();
		}
		else
		{
			ListNode slow = head.next;
			ListNode fast = slow.next;
			while (fast != null)
			{
				if (slow.data == fast.data)
				{
					fast = fast.next;
					slow.next = fast;
				}
				else
				{
					slow = slow.next;
					fast = fast.next;
				}
			}
		}

		return this;
	}

	public LinkedList moveNode(LinkedList destination)
	{
		ListNode destinationFirst = destination.head.next;
		ListNode destinationNext = destinationFirst.next;
		ListNode sourceFirst = head.next;
		ListNode sourceNext = sourceFirst.next;

		destinationFirst = sourceFirst;
		sourceFirst.next = destinationNext;
		head.next = sourceNext;

		return this;
	}

	public LinkedList alternatingSplit(LinkedList destination)
	{
		ListNode start = head.next.next;
		int index = 1;
		int originalSize = size;
		for (index = 2; index <= originalSize / 2; index++)
		{
			start = start.next;
			destination.add(detachNode(index));
		}
		if (originalSize % 2 == 0)
		{
			destination.add(detachNode(size));
		}
		else
		{
			destination.add(detachNode(size - 1));
		}
		return this;
	}

	public LinkedList alternatingMerge(LinkedList destination)
	{
		ListNode it = destination.head;
		int position = 2;
		int index = 1;
		while (it.next != null)
		{
			add(position, destination.detachNode(1));
			position = position + 2;
			index = index + 1;
		}
		return this;
	}

	public LinkedList sortedIntersect(LinkedList first, LinkedList next) {
		if (first == null || next == null)
			return null;
		else {
			ListNode i = first.head.next;
			ListNode j = next.head.next;

			while (i != null && j != null) {
				if(i.data < j.data)
				{
					i=i.next;
				}
				else if(i.data > j.data)
				{
					j=j.next;
				}
				else
				{
					add(i.data);
					i=i.next;
					j=j.next;
				}
			}
		}
		return this;
	}
	
	public void sortedMerge(LinkedList first, LinkedList another)
	{
		int originalSize=another.size;
		for(int index=1 ; index <= originalSize ; index++)
		{
			ListNode detached = another.detachNode(1);
			first.sortedInsert(detached);
		}
	}
	
	public LinkedList merge(LinkedList first, LinkedList next) {
		if (first == null)
			this.append(next);
		else if (next == null)
			this.append(first);
		else {
			ListNode i = first.head.next;
			ListNode j = next.head.next;

			while (i != null && j != null) {
				if (i.data <= j.data) {
					add(i.data);
					i = i.next;
				} else {
					add(j.data);
					j = j.next;
				}
			}

			while (i != null) {
				add(i);
				i = i.next;
			}

			while (j != null) {
				add(j);
				j = j.next;
			}
		}
		return this;
	}

	public ListNode detachNode(int position)
	{
		if (position > size + 1)
			return null;
		ListNode it = head.next;
		ListNode previous = head;
		for (int index = 1; index < position; index++)
		{
			it = it.next;
			previous = previous.next;
		}
		previous.next = it.next;
		it.next = null;
		size--;
		return it;
	}

	public void print()
	{
		ListNode it = head;
		if (head == null)
			return;
		if (size == 1)
		{
			System.out.print(it.next.data + "->");
		}
		else
		{
			it = it.next;
			while (it != null)
			{
				System.out.print(it.data + "->");
				it = it.next;
			}
		}
		System.out.print("NULL");
		System.out.println();
	}
	
	public LinkedList reverse()
	{
		if(size == 0) return null;
		if(size == 1) return this;
		ListNode i=head.next;
		ListNode j=i.next;

		if(size == 2)
		{
			j.next=i;
			i.next=null;
			head.next=j;
		}
		else
		{
			ListNode k = j.next;
			while(k != null)
			{
				j.next=i;
				i=j;
				j=k;
				k=k.next;
			}
			System.out.println(i.data);
			System.out.println(j.data);
			j.next=i;
			head.next.next=null;
			head.next=j;
		}
		return this;
	}
	
	public ListNode recursiveReverse(ListNode node)
	{
		if(node == null )
			return null;
		if(node.next == null )
			return node;
		
		ListNode reversed = recursiveReverse(node.next);
		node.next.next=node;
		node.next=null;
		return reversed;

	}

	public void printFrom(ListNode n)
	{
		StringBuilder sb = new StringBuilder();
		while(n !=null)
		{
			sb.append(n.data);
			sb.append("->");
			n=n.next;
		}
		sb.append("NULL");
		System.out.println(sb.toString());
	}
	
	public LinkedList clear()
	{
		head.next = null;
		size = 0;
		return this;
	}

	public int size()
	{
		return size;
	}
}

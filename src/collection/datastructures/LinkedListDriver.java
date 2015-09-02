package collection.datastructures;

public class LinkedListDriver
{
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		for(int index = 1 ; index <= 10 ; index++)
		{
			ListNode node = new ListNode(index);
			ll.add(node).print();
		}
		ll.add(5, new ListNode(5)).print();
		ll.remove().print();
		ll.remove(5).print();
		ll.remove(5).print();
		ll.remove(5).print();
		ll.remove(1).print();
		ll.remove(ll.size()).print();
		ll.sortedInsert(new ListNode(4)).print();
		ll.add(new ListNode(500)).add(new ListNode(400)).add(new ListNode(300)).print();
		ll.insertionSort().print();
		
		LinkedList ll2 = new LinkedList();
		ll2.add(new ListNode(1500)).add(new ListNode(1400)).add(new ListNode(1300)).print();
		
		ll.append(ll2).print();
		ll2.print();
		
		LinkedList firstHalf = new LinkedList();
		LinkedList secondHalf = new LinkedList();
		ll.split(firstHalf, secondHalf);
		LinkedList ll3 = new LinkedList();
		ll3.add(new ListNode(1)).add(new ListNode(2)).add(new ListNode(3)).add(new ListNode(4)).add(new ListNode(4)).add(new ListNode(5)).add(new ListNode(6)).add(new ListNode(7)).add(new ListNode(7)).print();
		ll3.removeDuplicates().print();
		
		LinkedList ll4 = new LinkedList();
		ll4.add(new ListNode(1)).add(new ListNode(2)).add(new ListNode(3)).add(new ListNode(4)).print();
		
		ll3.moveNode(ll4).print();
		ll4.print();
		
		ll4 = new LinkedList();
		ll4=ll4.add(new ListNode(1)).add(new ListNode(2)).add(new ListNode(3)).add(new ListNode(4000));
		
		LinkedList ll5 = new LinkedList();
		ll5=ll5.add(new ListNode(-100)).add(new ListNode(-99)).add(new ListNode(3)).add(new ListNode(55)).add(new ListNode(5000));
	
		LinkedList ll6 = new LinkedList();
		ll6.merge(ll4, ll5).print();
		
		System.out.println("====");
		ll4 = new LinkedList();
		ll4=ll4.add(new ListNode(1)).add(new ListNode(2)).add(new ListNode(3)).add(new ListNode(3)).add(new ListNode(55));
		
		ll5 = new LinkedList();
		for(int index = -15 ; index < 56 ; index++)
			ll5=ll5.add(index);
	
		ll6 = new LinkedList();
		ll6.sortedIntersect(ll4, ll5).print();
		
		ll6=new LinkedList();
		for(int index = 1 ; index <= 10 ; index++)
			ll6=ll6.add(index);
		ll6.print();
		ll6.reverse().print();
		
		ll6=new LinkedList();
		for(int index = 1 ; index <= 10 ; index++)
			ll6=ll6.add(index);
		ll6.print();
		System.out.println("=====");
		ListNode r = ll6.recursiveReverse(ll6.head);
		System.out.println();
		
	}
	
	
}

package problemsolving;

/*
Given a singly linked list of size N.
The task is to rotate the linked list counter-clockwise by k nodes, 
where k is a given positive integer smaller than or equal to length of the linked list.
*/
public class RotateLinkedList {



	public RotateLinkedList(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		head = node;
	}

	Node head;

	class Node {
		int data;
		Node next;
	}

	// rotate  a linked list counter clock wise by k element

	public void rotateLinkedListCounterClockWise(int k) {
      
		//  traverse from beginning and stop at just before k th node stor it as nodeBeforekthNode
		//  store kth node also as kthNode
		//  make next of nodeBeforekthNode to null and make next of lastNode  to head node
		// and finally make head as kthNode
		
		Node currentNode = head;
		Node nodeBeforekthNode = null;
		Node kthNode = null;
		Node lastNode = null; 
		int count = 1;
		while(currentNode.next != null) {
			if(count == k) {
				kthNode = currentNode;
			}
			if(count == k-1) {
				nodeBeforekthNode = currentNode;
			}
			currentNode = currentNode.next;
			lastNode = currentNode;
			count++;
		}
		
		lastNode.next = head;
		if(count == k) {
			head = lastNode;
		}else {
			head = kthNode;
		}
		nodeBeforekthNode.next = null;
		
	}

	public void insertAtEnd(int data) {

		if (head == null) {
			Node n = new Node();
			n.data = data;
			n.next = null;
			head = n;
		}

		Node currentNode = head;

		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}

		Node newNode = new Node();

		newNode.data = data;
		newNode.next = null;
		currentNode.next = newNode;
	}

	public void printList() {

		Node node = head;
		while (node.next != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println(node.data);
	}

	public int size() {
		int size = 0;
		Node currentNode = head;

		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;

		}
		return size;
	}

	public static void main(String[] args) {

		RotateLinkedList li = new RotateLinkedList(1);

		li.insertAtEnd(2);
		li.insertAtEnd(3);
		li.insertAtEnd(4);
		li.insertAtEnd(5);
		li.insertAtEnd(6);
		li.insertAtEnd(7);
		li.insertAtEnd(8);

	//	li.printList();

		System.out.println(li.size());
		
		int k = 4;
		li.rotateLinkedListCounterClockWise(k);
		
		li.printList();

	}


	
}

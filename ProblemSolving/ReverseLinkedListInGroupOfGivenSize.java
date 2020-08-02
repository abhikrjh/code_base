package problemsolving;

import problemsolving.ReverseLinkedList.Node;

public class ReverseLinkedListInGroupOfGivenSize {

	public ReverseLinkedListInGroupOfGivenSize(int data) {
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

	// reverse a linked list in group of given size

	public static void reverseLinkedListInGroupOfGivenSize(int k) {
		int count=0;
        
		
		
		
	}

	// reverse LinkedList
	
	public void reverseLinkedList() {

		Node previousNode = null;
		Node currentNode = head;
		Node nextNode = null;

		while (currentNode.next != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
        
		head = currentNode;
		head.next =previousNode;
		
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

		ReverseLinkedListInGroupOfGivenSize li = new ReverseLinkedListInGroupOfGivenSize(1);

		li.insertAtEnd(2);
		li.insertAtEnd(3);
		li.insertAtEnd(4);
		li.insertAtEnd(5);
		li.insertAtEnd(6);
		li.insertAtEnd(7);
		li.insertAtEnd(8);

		// li.printList();

		System.out.println(li.size());

	}

}

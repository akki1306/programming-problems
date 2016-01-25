package datastructure.linkedlist;

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}

}

public class RemoveDuplicatesFromLinkedList {
	public static Node removeDuplicates(Node head) {
		Set<Integer> set = new HashSet<Integer>();
		Node prev = head;
		Node next = head;
		Node current = head;
		while (current != null) {
			if (!set.add(current.data)) {
				prev.next = next;
			}else{
				prev = current;
			}
			current = current.next;
			if (current != null) {
				next = current.next;
			} else {
				next = null;
			}
		}
		return head;
	}

	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}

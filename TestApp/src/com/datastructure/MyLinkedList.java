/**
 * 
 */
package com.datastructure;



/**
 * @author Sudhansu
 *
 */

public class MyLinkedList{
	
	 public LinkedList root;
		
		public void printLinkedList(LinkedList root){
			LinkedList current = root;
			while(current!=null){
				System.out.print(current.data + ">");
				current = current.next;
			}
		}
		public void createList(int data){
			if(root == null){
				root = createNode(data);
				return;
			}
			LinkedList current = root;
			while(current.next!=null){
				current = current.next;
			}
			current.next  = createNode(data);

		}

		public LinkedList createNode(int data) {
			LinkedList node = new LinkedList();
			node.data = data;
			node.next = null;
			return node;
		}

	 public static void main(String[] args) {
		MyLinkedList m = new MyLinkedList();
		int []a = new int [] {1,2,3,4,5,6,7,8,9};

		for(int i:a){
		 m.createList(i);
		}
		m.printLinkedList(m.root);

		//m.root = m.reverseEveryK(m.root, 3);
		System.out.println();
		m.root = m.reverseList(m.root);
		m.printLinkedList(m.root);
	}
	 /**
	  * reverse every k elements in a linked list
	  */
	 /**
	  * 
	  * @param root
	  * @param k
	  * @return
	  */
	 LinkedList reverseEveryK(LinkedList root, int k){
		 LinkedList temp = root;
		 LinkedList prev = null;
		 LinkedList next = null;
		 int count = 0;
		 while(temp!=null && count <k){
			 next = temp.next;
			 temp.next = prev;
			 prev = temp;
			 temp = next;
			 count ++;
		 }
		 if(next!=null){
			 root.next = reverseEveryK(next, k);
		 }
		 root = prev;
		 return root;
	 }
	 
	
	LinkedList reverseList(LinkedList head){
		if(head == null || head.next == null)
			return head;
		LinkedList rest = head.next;
		head.next = null;
		LinkedList reverseLst = reverseList(rest);
		rest.next = head;
		return reverseLst;
	}
}

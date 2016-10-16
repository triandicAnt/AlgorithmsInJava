/**
 * 
 */
package com.datastructure.linkedlist;




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
		//m.printLinkedList(m.root);

		//m.root = m.reverseEveryK(m.root, 3);
		System.out.println();
		//m.root = m.reverseList(m.root);
		//m.printLinkedList(m.root);
		System.out.println();
		
		// reverse a list iterative
		int []b = new int [] {10,15,12,13,20,14};
		MyLinkedList ll = new MyLinkedList();
		for(int i:b){
			ll.createList(i);
		}
//		ll.printLinkedList(ll.root);
		System.out.println();
		//ll.root = ll.reverseListIterative(ll.root);
//		ll.root = ll.reverseListRecursive(ll.root);
//		ll.printLinkedList(ll.root);
		int [] c = new int [] {10,12,9,8,7,5}; 
		MyLinkedList ll1 = new MyLinkedList();
		for(int i:c){
			ll1.createList(i);
		}
		ll1.printLinkedList(ll1.root);
		
		ll1.root = ll1.swapLinkedLists(ll1.root, 10, 5);
		ll1.printLinkedList(ll1.root);

		
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
	 
	
	/*LinkedList reverseList(LinkedList head){
		if(head == null || head.next == null)
			return head;
		LinkedList rest = head.next;
		head.next = null;
		LinkedList reverseLst = reverseList(rest);
		rest.next = head;
		return reverseLst;
	}*/
	
	 /**
	  * Reverse linked list itertive
	  * @param root
	  * @return
	  */
	LinkedList reverseListIterative(LinkedList root){
		if(root == null || root.next == null)
			return root;
	
		LinkedList temp = root;
		LinkedList next = null;
		LinkedList prev = null;
		
		while(temp!=null){
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		return prev;
	}
	// 10>15>12>13>20>14>
	/**
	 *  Reverse linked list recursive
	 * @param root
	 * @return
	 */
	LinkedList reverseListRecursive(LinkedList root){
		if(root == null || root.next == null){
			return root;
		}
		LinkedList rest = root.next;
		root.next = null;
		LinkedList reverseHead = reverseListRecursive(rest);
		rest.next = root;
		return reverseHead;
	}
	
	LinkedList swapLinkedLists(LinkedList head, int x, int y){
		if(head == null || head.next == null)
			return head;
		LinkedList curX = head;
		LinkedList preX = null;
		LinkedList curY  = head;
		LinkedList preY = null;
		
		while(curX!=null && curX.data != x)
		{
			preX = curX;
			curX = curX.next;
		}
		while(curY!=null && curY.data != y)
		{
			preY = curY;
			curY = curY.next;
		}
		if(curX == null || curY == null)
			return head;
		
		// System.out.println("\n" + preX.data + " " + curX.data + " " + preY.data + " "+ curX.data);
		// add check for x or y being root
		
		// also add check for next of x and y being null
		
		//else swap nodes
		System.out.println();
		if(preX!= null)
			preX.next = curY;
		else
			head = curY;
		
		if(preY!= null)
			preY.next = curX;
		else
			head = curX;
		// temp var to keep track of next pointer
		LinkedList temp = curX.next; 
		curX.next = curY.next;
		curY.next = temp;
//		
		return head;
	}
	
}

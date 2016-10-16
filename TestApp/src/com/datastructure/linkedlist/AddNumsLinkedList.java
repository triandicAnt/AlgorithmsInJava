package com.datastructure.linkedlist;


public class AddNumsLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList head1 = new LinkedList(5);
		LinkedList temp1 = head1;
		temp1.next = new LinkedList(6);
		temp1 = temp1.next;
		temp1.next = new LinkedList(3);
		
		LinkedList head2 = new LinkedList(8);
		LinkedList temp2 = head2;
		temp2.next = new LinkedList(4);
		temp2 = temp2.next;
		temp2.next = new LinkedList(2);
		
		printLinkedList(head1);
		System.out.println();
		printLinkedList(head2);
		System.out.println();
		LinkedList head = addList(head1, head2);
		printLinkedList(head);
		System.out.println("-----------------");
		LinkedList head3 = new LinkedList(3);
		LinkedList temp3 = head3;
		temp3.next = new LinkedList(2);
		temp3 = temp3.next;
		temp3.next = new LinkedList(1);
		
		LinkedList head4 = new LinkedList(9);
		LinkedList temp4 = head4;
		temp4.next = new LinkedList(8);
//		temp4 = temp4.next;
//		temp4.next = new LinkedList(2);
		printLinkedList(head3);
		System.out.println();
		printLinkedList(head4);
		System.out.println();
		printLinkedList(addList(head3, head4));
		LinkedList head5 = new LinkedList(5);
		LinkedList head6 = new LinkedList(5);
		System.out.println();
		printLinkedList(addList(head5, head6));
		

	}
	public static void printLinkedList(LinkedList root){
		LinkedList current = root;
		while(current!=null){
			System.out.print(current.data + ">");
			current = current.next;
		}
	}
	/*
	 * First List: 5->6->3 // represents number 365
		Second List: 8->4->2 // represents number 248
		Output
		Resultant list: 3->1->6 // represents number 613
	 */
	static LinkedList addList(LinkedList head1,LinkedList head2){
		if(head1==null && head2==null)
			return null;
		if(head1==null)
			return head2;
		if(head2 == null)
			return head1;
		LinkedList head = null;
		LinkedList temp1 = head1;
		LinkedList temp2 = head2;

		int data = temp1.data + temp2.data;
		head = new LinkedList(data%10);
		int carry = 0;
		carry = data/10;
		LinkedList temp = head;
		temp1 = temp1.next;
		temp2 = temp2.next;
		
		while(temp1!=null && temp2!=null){
			 data = temp1.data + temp2.data + carry;
			// 12
			// head.data = 2.. carry 1
			temp.next = new LinkedList(data%10);
			carry = data/10;
			temp1 = temp1.next;
			temp2 = temp2.next;
			temp = temp.next;
		}
		if(temp1!=null){
			while(temp1!=null){
				temp.next = new LinkedList(temp1.data%10 + carry);
				carry = 0;
				temp = temp.next;
				temp1= temp1.next;
			}
		}
		// check for second node
		if(temp2!=null){
			while(temp2!=null){
				temp.next = new LinkedList(temp2.data%10 + carry);
				carry = 0;
				temp = temp.next;
				temp1= temp2.next;
			}
		}
		if(carry!=0){
		    temp.next = new LinkedList(carry);
		}
		return head;
	}
}

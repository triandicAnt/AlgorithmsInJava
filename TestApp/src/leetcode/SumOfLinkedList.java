package leetcode;


public class SumOfLinkedList {
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(5);
		ListNode temp1 = head1;
		temp1.next = new ListNode(6);
		temp1 = temp1.next;
		temp1.next = new ListNode(3);

		ListNode head2 = new ListNode(8);
		ListNode temp2 = head2;
		temp2.next = new ListNode(4);
		temp2 = temp2.next;
		temp2.next = new ListNode(2);

		printLinkedList(head1);
		System.out.println();
		printLinkedList(head2);
		System.out.println();
		ListNode head = addTwoNumbers(head1, head2);
		printLinkedList(head);
		System.out.println("-----------------");
		ListNode head3 = new ListNode(3);
		ListNode temp3 = head3;
		temp3.next = new ListNode(2);
		temp3 = temp3.next;
		temp3.next = new ListNode(1);

		ListNode head4 = new ListNode(9);
		ListNode temp4 = head4;
		temp4.next = new ListNode(8);
//				temp4 = temp4.next;
//				temp4.next = new ListNode(2);
		printLinkedList(head3);
		System.out.println();
		printLinkedList(head4);
		System.out.println();
		printLinkedList(addTwoNumbers(head3, head4));
		ListNode head5 = new ListNode(5);
		ListNode head6 = new ListNode(5);
		System.out.println();
		printLinkedList(addTwoNumbers(head5, head6));

	}
	public static void printLinkedList(ListNode root){
		ListNode current = root;
		while(current!=null){
			System.out.print(current.val + ">");
			current = current.next;
		}
	}
	 public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
	        if(head1==null && head2==null)
				return null;
			if(head1==null)
				return head2;
			if(head2 == null)
				return head1;
			ListNode head = null;
			ListNode temp1 = head1;
			ListNode temp2 = head2;

			int val = temp1.val + temp2.val;
			head = new ListNode(val%10);
			int carry = 0;
			carry = val/10;
			ListNode temp = head;
			temp1 = temp1.next;
			temp2 = temp2.next;
			
	        while(temp1!=null || temp2!=null){
				val = 0;

	            if(temp1!=null){
	                val += temp1.val;
	                temp1 = temp1.next;
	            }
	            if(temp2!=null){
	                val+=temp2.val;
	                temp2=temp2.next;
	            }
				 val +=  carry;
				temp.next = new ListNode(val%10);
				carry = val/10;
				temp = temp.next;
			}
		
			if(carry!=0){
			    temp.next = new ListNode(carry);
			}
			return head;
	        
	    }
}

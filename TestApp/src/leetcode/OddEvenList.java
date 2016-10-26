/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1,2,3,4,5,6,7,8]
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		printList(oddEvenList(head));

	}
	 public static ListNode oddEvenList(ListNode head) {
	        
	        if(head == null || head.next == null)
	            return head;
	        // odd
	        ListNode cur = head;
	        ListNode odd = head;
	        ListNode oddCur = odd;
	        
	        //even
	        ListNode even = head.next;
	        ListNode evenCur = even;
	        
	        cur = cur.next.next;
	        
	        while(cur!=null){
	        	
	        	// set the off list
	        	
	            oddCur.next = cur;
	            oddCur = oddCur.next;
	            
	            // set the even list 
	            evenCur.next = cur.next;
	            evenCur = evenCur.next;
	           // cur = cur.next;
	            if(cur.next!=null)
	              cur = cur.next.next;
	            else{
	            	cur = cur.next;
	            }
	        }
	       
	        oddCur.next = null;
	        printList(even);
	        printList(odd);
	        oddCur.next = even;
	        return odd;
	        
	    }
	    
	    public static void printList(ListNode head){
	        ListNode cur = head;
	        while(cur!=null){
	            System.out.print(cur.val + ",");
	            cur=cur.next;
	        }
	        System.out.println();
	    }
}

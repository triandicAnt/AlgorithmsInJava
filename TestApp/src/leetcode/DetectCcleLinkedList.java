/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class DetectCcleLinkedList {
	 public ListNode detectCycle(ListNode head) {
	        if(head == null || head.next == null)
	            return null;
	        ListNode slow = head;
	        ListNode fast = head;
	        // ListNode slow = head.next;
	        // ListNode fast = head.next.next;
	        // while(slow!=null && head!=null && head.next!=null && slow!=fast){
	        //     slow= slow.next;
	        //     fast = fast.next;
	        // }
	        // if(slow==null || fast==null)
	        //     return null;
	        // slow = head;
	        // while(slow!=fast){
	        //     slow = slow.next;
	        //     fast = fast.next;
	        // }
	        // return slow;
	        while(fast != null){
	            slow = slow.next;
	            fast = fast.next;
	            if(fast != null) fast = fast.next;
	            if(fast == slow){
	                fast = head;
	                while(slow != fast){
	                    fast = fast.next;
	                    slow = slow.next;
	                }
	                return slow;
	            }


	        }

	        return null;
	    }
}

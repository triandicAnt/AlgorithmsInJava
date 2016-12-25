/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class InsertionSortLinkedList {

	 public ListNode insertionSortList(ListNode head) {
	        if(head==null || head.next==null)
	            return head;
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        while(head!=null && head.next!=null){
	            if(head.val<head.next.val)
	                head = head.next;
	            else{
	                ListNode temp = head.next;
	                ListNode cur = dummy;
	                while(cur.next.val<temp.val){
	                    cur = cur.next;
	                }
	                head.next = temp.next;
	                temp.next = cur.next;
	                cur.next = temp;
	            }
	        }
	        return dummy.next;
	    }
}

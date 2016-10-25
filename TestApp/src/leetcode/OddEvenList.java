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
	}
	 public ListNode oddEvenList(ListNode head) {
	        
	        if(head == null || head.next == null)
	            return head;
	        ListNode cur = head;
	        ListNode odd = head;
	        ListNode oddCur = odd;
	        ListNode even = head.next;
	        ListNode evenCur = even;
	        ListNode curEven = cur.next;
	        if(curEven.next!=null)
	            curEven = curEven.next.next;
	        
	        cur = cur.next.next;
	        ListNode oddPrev = cur;
	        while(cur!=null){
	            oddCur.next = cur;
	            oddPrev = oddCur;
	            oddCur = oddCur.next;
	            if(cur.next!=null)
	              cur = cur.next.next;
	        }
	        System.out.println(oddCur.val);
	         while(curEven!=null){
	            evenCur.next = curEven;
	            evenCur = evenCur.next;
	            if(curEven.next!=null)
	                curEven = curEven.next.next;
	        }

	       // evenCur.next = null;
	        //oddCur.next = null;

	        printList(even);
	        oddPrev.next = even;
	        return odd;
	        
	    }
	    
	    public void printList(ListNode head){
	        ListNode cur = head;
	        while(cur!=null){
	            System.out.print(cur.val + ",");
	            cur=cur.next;
	        }
	        System.out.println();
	    }
}

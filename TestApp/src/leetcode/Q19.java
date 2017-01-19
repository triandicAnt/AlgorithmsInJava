/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode slow  = dummy;
        ListNode fast = dummy;
        dummy.next=head;
        
        while(n>=0){
            fast = fast.next;
            n--;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next==null?null:slow.next.next;
        return dummy.next;
    }
}

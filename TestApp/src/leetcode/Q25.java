/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next == null)
            return head;
        
        ListNode cur = head;
        ListNode  prev = null;
        ListNode next = null;

        int count = 0 ;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        if(count<k)
            return head;
        count =0;
        cur=head;
        while(cur!=null && count <k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count ++;
        }
        if(next!=null)
            head.next = reverseKGroup(next, k);
        //head = prev;
        return prev;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGrp {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next == null)
            return head;
        int count =0;
        ListNode cur = head;
        while(cur!=null)
        {
            count ++;
            cur = cur.next;
        }
        if(count<k)
            return head;
        count = 0;
        cur = head;
        ListNode prev = null;
        ListNode next = null;
        while(cur!=null && count<k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count ++;
        }
        if(cur!=null)
            head.next = reverseKGroup(cur,k);
        return prev;
    }
    
}

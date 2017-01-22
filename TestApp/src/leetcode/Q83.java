/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur!=null && next!=null){
            while(cur!=null && next!=null && next.val == cur.val){
                cur.next = next.next;
                 if(cur!=null)
                next = cur.next;
            }
            cur = cur.next;
            if(cur!=null)
                next = cur.next;
        }
        return dummy.next;
    }
}

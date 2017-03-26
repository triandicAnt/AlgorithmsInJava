/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode slow = head, fast = head, prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                 cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            cur.next = l1;
        if(l2!=null)
            cur.next = l2;
        return temp.next;
    }
}

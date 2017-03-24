/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode res = head.next;
        head.next = null;
        ListNode revList = reverseList(res);
        res.next = head;
        return revList;
    }
}

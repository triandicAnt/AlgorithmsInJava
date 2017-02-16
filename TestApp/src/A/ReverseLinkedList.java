/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
       /* if(head==null || head.next==null)
            return head;
        ListNode rest = head.next;
        head.next = null;
        ListNode reverseList = reverseList(rest);
        rest.next = head;
        return reverseList;*/
        return reverseIter(head);
        
    }
    public ListNode reverseIter(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListI {
    public ListNode reverseList(ListNode head) {
       /* if(head==null|| head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;*/
        return reverseListRecursive(head);
    }
    public ListNode reverseListRecursive(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode rest = head.next;
        head.next = null;
        ListNode newRoot = reverseListRecursive(rest);
        rest.next = head;
        return newRoot;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q24 {
    public ListNode swapPairs(ListNode head) {
      
        int k = 2;
        return reverseKNodes(head, k);

    }
    public ListNode reverseKNodes(ListNode head, int k){
        if(head == null || head.next == null)
            return head;
        
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while(cur!=null && count<k){
            next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            count++;
        }
        if(next!=null)
            head.next = reverseKNodes(next, k);
        return prev;
    }
}

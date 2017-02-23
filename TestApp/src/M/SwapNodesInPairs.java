/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        return reverseKNodes(head,2);
    }
    public ListNode reverseKNodes(ListNode head, int k){
        if(head==null)
            return null;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while(cur!=null && count<k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        if(cur!=null){
            head.next = reverseKNodes(cur,k);
        }
            
        return prev;
    }
}

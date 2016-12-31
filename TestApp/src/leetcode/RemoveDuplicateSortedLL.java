package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicateSortedLL {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode newHead = head;

        while(cur!=null){
            while(next!=null && cur.val==next.val){
                cur=next;
                next=next.next;
                prev.next = next;
            }

             if(prev.next==cur){
                prev=cur;
            }else{
                prev.next=next;
            }
            cur = next;
            if(next!=null)
                next = next.next;
            
        }
        
        return dummy.next;
    }
}

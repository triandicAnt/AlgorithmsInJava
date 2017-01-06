/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null|| k==0)
            return head;
        int l = 0;
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            l++;
            prev = cur;
            cur = cur.next;
        }
        if(k==l || k%l==0)
            return head;
        if(k>l){
            while(k>l)
                k = k-l;
        }
            
        int n = l-k;
        cur = head;
        while(cur!=null && n>1){
            cur = cur.next;
            //next = next.next;
            n--;
        }
       ListNode next = head;
       if(cur!=null)
        next = cur.next;
        cur.next = null;
        prev.next = head;
        return next;
    }
}

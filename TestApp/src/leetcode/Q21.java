/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode f = null;
        if(l1.val>l2.val){
            f = l2;
            l2 = l2.next;
        }
        else{
            f = l1;
            l1 = l1.next;
        }
        ListNode cur = f;
        
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }else{
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        cur.next = (l1!=null)?l1:l2;
        return f;
    }
}

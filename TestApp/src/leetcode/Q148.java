/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class Q148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail;
        ListNode left;
        ListNode right;
        
        for(int i=1;i<len;i<<=1){
            cur = dummy.next;
            tail = dummy;
            while(cur!=null){
                left = cur;
                right = split(left, i);
                cur = split(right, i);
                tail = merge(left,right,tail);
            }
        }
        return dummy.next;
    }
    // split by n and return head of second
    public ListNode split(ListNode head, int n){
        ListNode cur = head;
        ListNode prev = cur;
        while(cur!=null && n!=0){
            prev = cur;
            cur = cur.next;
            n--;
        }
        if(cur==null)
            return null;
        prev.next = null;
        return cur;
    }
    // merge l1 and l2 in the tail->min(l1, l2)....
    // return the tail of the merged list
    public ListNode merge(ListNode l1, ListNode l2, ListNode tail){
        ListNode cur = tail;
        while(l1!=null && l2 != null){
            if(l1.val>l2.val){
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        cur.next = l1!=null?l1:l2;
        while(cur.next!=null)
            cur = cur.next;
        return cur;
    }
}

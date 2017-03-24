/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        int carry = 0;
        while(l1!=null && l2!=null){
            int x = l1.val+l2.val + carry;
            carry = x/10;
            cur.next = new ListNode(x%10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while(l1!=null){
            int x = l1.val + carry;
            carry = x/10;
            cur.next = new ListNode(x%10);
            l1 = l1.next;
            cur = cur.next;
        }
         while(l2!=null){
            int x = l2.val + carry;
            carry = x/10;
            cur.next = new ListNode(x%10);
            l2 = l2.next;
            cur = cur.next;
        }
        if(carry!=0)
            cur.next = new ListNode(carry);
        return temp.next;   
        
    }
}

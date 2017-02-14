/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        int x = cur1.val+cur2.val;
        ListNode head = new ListNode(x%10);
        ListNode cur = head;
        carry = x/10;
        cur1 = cur1.next;
        cur2 = cur2.next;
        
        while(cur1!=null && cur2!=null){
            x = cur1.val+cur2.val + carry;
            cur.next = new ListNode(x%10);
            carry = x/10;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next;
        }
        while(cur1!=null){
            x = cur1.val + carry;
            cur.next = new ListNode(x%10);
            carry = x/10;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while(cur2!=null){
            x = cur2.val + carry;
            cur.next = new ListNode(x%10);
            carry = x/10;
            cur2 = cur2.next;
            cur = cur.next;
        }
        if(carry>0){
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return head;
        
    }
}

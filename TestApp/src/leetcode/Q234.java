/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        if(head.next.next==null)
            return head.val==head.next.val;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;

        //reverse the second half;
        ListNode cur = slow;
        ListNode prev = null;
        ListNode next = slow;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        slow = prev;
        cur = head;
        while(slow!=null){
                    System.out.println(slow.val);

            if(cur.val!=slow.val)
                return false;
            slow = slow.next;
            cur = cur.next;
        }
        
        return true;
    }
    
     public boolean isPalindrome(ListNode head) {
        if(head==null || head.next ==null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;
        
        slow = reverseList(slow);
        fast = head;
        while(slow!=null && fast!=null){
            if(slow.val!=fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode rest = head.next;
        head.next = null;
        ListNode reversedList = reverseList(rest);
        rest.next = head;
        return reversedList;
    }
}

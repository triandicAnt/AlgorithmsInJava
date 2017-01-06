/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q143 {
    public void reorderList(ListNode head) {
        if(head==null || head.next ==null)
            return ;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1>2>3>4>5>6
        // 1>2>3>6>5>4
        ListNode preNode = slow;
        ListNode cur = preNode.next;
        ListNode next = cur;
        ListNode prev = null;
        preNode.next = null;
        while(next!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //preNode.next = prev;
        //printNode(head);
        // 1>2>3>6>5>4
        // 1>6>2>5>3>4
        ListNode first = head;
        ListNode firstNext = first.next;
        ListNode second = prev;
        ListNode secondNext = second.next;
        while(first!=null && second!=null){
            first.next = second;
            first = firstNext;
            if(firstNext!=null)
                firstNext = firstNext.next;
            second.next = first;
            second = secondNext;
            if(secondNext!=null)
                secondNext = secondNext.next;
        }
        
        
    }
    public void printNode(ListNode head){
        while(head!=null){
            System.out.print(head.val + ">");
            head = head.next;
        }
    }
}

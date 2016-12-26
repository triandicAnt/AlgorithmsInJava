/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNodePartition {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode c1 = d1;
        ListNode c2 = d2;
        
        while(head!=null ){
            if(head.val<x){
                c1.next = head;
                c1 = c1.next;
            }else{
                c2.next = head;
                c2 = c2.next;
            }
            head = head.next;
          }
          c2.next = null;
          c1.next = d2.next;
          return d1.next;
    }
}

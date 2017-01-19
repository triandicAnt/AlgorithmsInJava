/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        return removeElement(head,val);
    }
    
    public ListNode removeElement(ListNode head, int val){
        if(head==null)
            return null;
        head.next = removeElement(head.next,val);
        return head.val==val?head.next:head;
    }
    public ListNode removeElementIter(ListNode head, int val){
        if(head==null)
            return head;
        // if(head.val == val){
        //     return head.next;
        // }
        ListNode cur = head;
        int c = 0;
        while(cur!=null)
            {
                cur = cur.next;
                c++;
            }
        cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev=dummy;
        int x = 0;
        while(cur!=null){
            if(cur.val==val){
                prev.next = cur.next;
                cur = cur.next;
                x++;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        System.out.println(x + " " + c);
        if(x==c)
            return null;
        return dummy.next;
    }
}

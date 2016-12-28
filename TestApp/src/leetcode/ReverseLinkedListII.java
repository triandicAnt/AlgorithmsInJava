/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m==n)
            return head;
        // create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev =dummy;
        int i = 1;
        while(i<m){
            prev = prev.next;
            i++;
        }
        ListNode curr = prev.next;
        ListNode then = curr.next;
        
        for(int j=0;j<n-m;j++){
            curr.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = curr.next;
        }
        return dummy.next;
            
        // int k = n-m;
        // int x = m;
        // ListNode temp = head;
        // ListNode prev = head;
        // ListNode next = head;
        // int count = 0;
        // while(x>1){
        //     prev = temp;
        //     next = temp;
        //     temp = temp.next;
        //     x--;
        // }
        // ListNode prevPtr = prev;
        // prev = null; 
        //  // reverse K nodes from here
        // while(temp!=null && count<=k){
        //     next = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = next;
        //     count++;
        // }
        // //System.out.println(prev.val + "  "+ temp.val);
        // //prevPtr.next = prev;
        // //temp.next = next;
        // return head;
        
    }
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur.next!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = prev;
        prev = cur;
        return prev;
    }
}

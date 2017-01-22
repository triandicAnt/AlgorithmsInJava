/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int n1 = 0;
        int n2 = 0;
        
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=null){
            curA = curA.next;
            n1++;
        }
        while(curB!=null){
            curB = curB.next;
            n2++;
        }
        curA=headA;
        curB = headB;
        int x = 0;
        x = (n1>n2)?n1-n2:n2-n1;
        if(n1>n2){
            while(x!=0){
                if(curA==curB){
                    return curA;
                }
                curA = curA.next;
                x--;
            }
        }else{
            while(x!=0){
                 if(curA==curB){
                    return curA;
                }
                curB=curB.next;
                x--;
            }
        }
        while(curA!=null &&  curB!=null){
            if(curA==curB)
                return curA;
            curA  = curA.next;
            curB = curB.next;
        }
        return null;
    }
}

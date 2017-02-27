/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Q138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return head;
        //if(head.next==null)
        //    return new RandomListNode(head.label);
        RandomListNode cur = head;
        RandomListNode next = null;
        while(cur!=null){
            next = cur.next;
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        RandomListNode newHead = cur.next;
        RandomListNode newCur = cur.next;
        // assign random pointer
        while(cur!=null){
            if(cur.random!=null)
                newCur.random = cur.random.next;
            cur = newCur.next;
            if(cur!=null)
                newCur = cur.next;
            
        }
        cur = head;
        newCur = newHead;
        while(cur!=null){
            cur.next = newCur.next;
            if(cur.next!=null)
                newCur.next = cur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}

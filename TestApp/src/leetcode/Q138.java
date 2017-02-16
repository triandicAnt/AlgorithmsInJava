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
            return null;
        RandomListNode cur = head;
        RandomListNode next;
        while(cur!=null){
            next = cur.next;
            RandomListNode newNode = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = next;
            cur = newNode.next;
        }
        // copy random pointers
        cur = head;
        next = cur.next;
        while(cur!=null && next!=null){
            if(cur.random==null)
                next.random = null;
            else    
                next.random = cur.random.next;
            cur = next.next;
            if(cur!=null)
                next = cur.next;
        }
        // seperate the lists
        cur = head;
        next = cur.next;
        RandomListNode newHead = next;
        while(cur!=null && next!=null){
            cur.next = next.next;
            if(cur.next==null)
                next.next = null;
            else
                next.next = cur.next.next;
            cur = cur.next;
            next = next.next;
        }
        return newHead;
        
    }
    
    public RandomListNode copyWithMap(RandomListNode head){
        if(head==null)
            return head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur!=null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        for(Map.Entry<RandomListNode,RandomListNode> e: map.entrySet()){
            RandomListNode newNode = e.getValue();
            newNode.next = map.get(e.getKey().next);
            newNode.random = map.get(e.getKey().random);
        }
        
        return map.get(head);
    }
}

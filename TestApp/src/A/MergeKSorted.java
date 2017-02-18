/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1,ListNode l2){
                Integer i1 = l1.val;
                Integer i2 = l2.val;
                return i1-i2;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode l : lists){
            if(l!=null)
            q.offer(l);
        }
        while(!q.isEmpty()){
            cur.next = q.poll();
            cur = cur.next;
            if(cur.next!=null)
                q.offer(cur.next);
        }
        return dummy.next;
    }
}

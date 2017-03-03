/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
                public int compare(ListNode l1, ListNode l2){
                    if(l1.val<l2.val)
                        return -1;
                    else if(l1.val>l2.val)
                        return 1;
                    else 
                        return 0;
                }
            });
       for(ListNode l:lists){
           if(l!=null)
                pq.add(l);
       }
       System.out.println(pq.size());
       ListNode dummy = new ListNode(0);
       ListNode cur = dummy;
       while(pq.size()>0){
           cur.next = pq.poll();
           cur = cur.next;
           if(cur!=null && cur.next!=null)
                pq.add(cur.next);
       }
       return dummy.next;
    }
}

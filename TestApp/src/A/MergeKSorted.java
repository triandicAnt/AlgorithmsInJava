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
      public ListNode mergeKLists(ListNode[] lists) {
       
      List<ListNode> arrList = new ArrayList<ListNode>(Arrays.asList(lists)); 
      return mergeLists(arrList);

    }
    public ListNode mergeLists(List<ListNode> lists) {
         if(lists==null || lists.size()==0)
            return null;
        if(lists.size()==1)
            return lists.get(0);
        else if(lists.size()==2)
            return mergeTwoList(lists.get(0),lists.get(1));
        else{
            return mergeTwoList(mergeLists(lists.subList(0, lists.size()/2)),mergeLists(lists.subList(lists.size()/2,lists.size())));
        }
    }
    
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head ;
        if(cur1.val>cur2.val){
            head = cur2;
            cur2=cur2.next;
        }else{
            head = cur1;
            cur1 = cur1.next;
        }
        ListNode cur = head;
        while(cur1!=null && cur2!=null){
           if(cur1.val>cur2.val){
                cur.next = cur2;
                cur2=cur2.next;
            }else{
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }
        while(cur1!=null){
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while(cur2!=null){
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
        return head;
    }
}

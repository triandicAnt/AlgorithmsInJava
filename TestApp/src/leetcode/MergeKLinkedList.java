/**
 * 
 */
package leetcode;
import java.util.PriorityQueue;


/**
 * @author Sudhansu
 * 
 */
public class MergeKLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length < 1)
			return null;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (ListNode node : lists) {
			System.out.println(node);
			if (node != null) {
				ListNode cur = node;
				while (cur != null) {
					pq.offer(cur.val);
					cur = cur.next;
				}
			}
		}
		if (pq == null || pq.size() < 1)
			return null;
		Integer i = pq.poll();

		ListNode newList = new ListNode(i);
		ListNode curNew = newList;
		while (pq.size() > 0) {
			curNew.next = new ListNode(pq.poll());
			curNew = curNew.next;
		}
		return newList;
	}

}

/**
 * 
 */
package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Sudhansu
 *
 */
public class KthLargestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	        for(int a : nums){
	            pq.add(a);
	        }
	        while(pq.size()>0 && k>1){
	            pq.poll();
	            k--;
	        }
	        return pq.peek();
	        
	    }
}

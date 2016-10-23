/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;

/**
 * @author Sudhansu
 *
 */
public class KthSmallestInMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = matrix.length;
        if(n<1)
            return 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.offer(matrix[i][j]);
            }
        }
        System.out.println(pq);
        while(pq.size()>0 && k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}

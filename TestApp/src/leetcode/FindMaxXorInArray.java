/**
 * 
 */
package leetcode;

import java.util.HashSet;

/**
 * @author Sudhansu
 *
 */
public class FindMaxXorInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(2<<2);
		int [] a = {14, 11, 7, 2};
		
		findMaximumXOR(a);

	}
	
	 public static int findMaximumXOR(int[] nums) {
	        if(nums == null || nums.length <=0)
	            return Integer.MIN_VALUE;
	        int max=0;
	        int mask=0;
	        for(int i=31;i>=0;i--){
	            HashSet<Integer> set = new HashSet<Integer>();
	            set.clear();
	            mask |= (1<<i);
	            System.out.println("--->"+mask);
	            for(int a: nums){
	                set.add(a&mask);
	            }
	            System.out.println(set);
	            int temp = max|(1<<i);
	            System.out.println("+++"+temp);

	            for(int a:set){
	                if(set.contains(temp^a)){
	                    max = temp;
	                    break;
	                }
	            }
	        }
	        return max;
	    }

}

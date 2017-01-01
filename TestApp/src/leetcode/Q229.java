/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class Q229 {
	  public List<Integer> majorityElement(int[] nums) {
	        List<Integer> list = new ArrayList<Integer>();
	        if(nums==null || nums.length<=0)
	            return list;
	        int count1 = 0;
	        int count2 = 0;
	        int candidate1 = Integer.MIN_VALUE;
	        int candidate2 = Integer.MIN_VALUE;
	        for(int a: nums){
	            if(a == candidate1){
	                count1+=1;
	            }else if(a == candidate2){
	                count2+=1;
	            } else if(count1==0){
	                candidate1 = a;
	                count1 = 1;
	            }else if(count2 == 0){
	                candidate2 = a;
	                count2 = 1;
	            }else {
	                count1-=1;
	                count2-=1;
	            }
	        }
	            // in second pass count the number of candidate1 and candidate2
	        count1 =0;
	        count2 =0;
	        for(int a : nums){
	            if(a==candidate1)
	                count1++;
	            else if(a == candidate2)
	                count2++;
	        }
	        if(count1>nums.length/3)
	            list.add(candidate1);
	        if(candidate2!=Integer.MIN_VALUE && candidate2!=candidate1){
	            if(count2>nums.length/3)
	                list.add(candidate2);
	        }
	        return list;
	    }
}

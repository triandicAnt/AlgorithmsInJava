/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class CheckTriplets {
	public boolean increasingTriplet(int[] nums) {
        int [] a = new int[nums.length];
        Arrays.fill(a, 1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    a[i] = a[j]+1;
                    if(a[i]>=3)
                        return true;
                }
            }
        }
        return false;
        
    }
}

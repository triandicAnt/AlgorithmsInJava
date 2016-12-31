/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class Q31 {
	 public void nextPermutation(int[] nums) {
	       // System.out.println(Arrays.toString(nums));
	       if(nums.length<=1)
	        return;
	        
	        int l = 0;
	        int h = nums.length-1;
	        int x = Integer.MAX_VALUE;
	        for(int i = h;i>=1;i--){
	            if(nums[i]>nums[i-1]){
	                x = i-1;
	                break;
	            }
	        }
	        // if x is not found then the array is soeted in reverse order
	        // simply sort the array
	        if(x==Integer.MAX_VALUE){
	            Arrays.sort(nums);
	            return;
	        }
	        System.out.println(x);
	        int y = x;
	        int max = nums[x+1];
	        for(int i = x; i<h;i++){
	            if(nums[i+1]>nums[x]){
	                if(max>=nums[i+1]){
	                    max = nums[i+1];
	                    y = i+1; 
	                }
	            }
	        }
	        // swap x and y
	        int temp = nums [x];
	        nums[x] = nums[y];
	        nums[y] = temp;
	        // reverse x to h
	        reverse(nums,x+1,h);
	        return;
	        // done!
	    }
	    public void reverse(int [] temp, int l, int h){
	        while(l<h){
	            int t = temp[l];
	            temp[l] = temp[h];
	            temp[h] = t;
	            l++;
	            h--;
	        }
	    }
}

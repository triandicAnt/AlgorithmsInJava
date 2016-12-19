/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {2,1};
		sortColors(a);
		System.out.println(Arrays.toString(a));

	}
	 public static void sortColors(int[] nums) {
	        
	        if(nums.length==0 || nums.length==1)
	            return;
	       int low = 0;
	       int high = nums.length-1;
	       for(int i = low;i<=high;){
	    	   if(nums[i]==0){
	    		   //swap nums[low],nums[i]
	    		   swap(nums,i,low);
	    		   i++;
	    		   low++;
	    	   }else if(nums[i]==2){
	    		   //swap nums[high] and nums[i]
	    		   swap(nums,i,high);
	    		   high--;
	    	   }else{
	    		   i++;
	    	   }
	       }
	        
	    }
	    public static void swap(int [] nums, int x,int y){
	        int temp = nums[x];
	        nums[x] = nums[y];
	        nums[y] = temp;
	    }
}

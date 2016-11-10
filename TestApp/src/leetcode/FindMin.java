/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {2,1};
		System.out.println(findMin(a));

	}
	
	  public static int findMin(int[] nums) {
	        if(nums == null || nums.length<=0)
	            return Integer.MIN_VALUE;
	        int l = 0;
	        int h = nums.length-1;
	        if(l==h)
	            return nums[l];
	        return findMinimum(nums, l, h);
	    }
	    public static int findMinimum(int [] nums, int l, int h){
	        if(l>h)
	            return nums[l];
	        int mid = l + (h-l)/2;
	        if(mid>0 && mid+1 < nums.length && nums[mid-1]>nums[mid] && nums[mid]<nums[mid+1]){
	            return nums[mid];
	        }
	        if(nums[h] < nums[mid]){
	            return findMinimum(nums, mid+1, h);
	        }else{
	            return findMinimum(nums, l, mid-1);
	        }
	        
	    }
}

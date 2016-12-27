/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class SearchForARange {
	  public int[] searchRange(int[] nums, int target) {
	        if(nums.length<=0)
	            return null;
	        int [] temp = new int [2];
	        Arrays.fill(temp,-1);
	        if(nums[0]==target){
	            temp[0] = 0;
	        }if(nums[nums.length-1]==target){
	            temp[1] = nums.length-1;
	        }
	        
	        search(nums,target,temp,0,nums.length-1);
	        return temp;
	    }
	    public void search(int []nums, int target, int []temp, int l,int h){
	        if(l>h)
	            return;
	        int m = (l+h)/2;
	        if(nums[m]==target){
	            if(m>0 && nums[m-1]!=target){
	                temp[0]=m;
	            }
	            if(m+1<nums.length && nums[m+1]!=target){
	                temp[1]=m;
	            }
	        }
	        if(temp[0]!=-1 && temp[1]!=-1)
	            return;
	        if(nums[m]>target)
	            search(nums,target,temp,l,m-1);
	        else if(nums[m]<target)
	            search(nums,target,temp,m+1,h);
	        else{
	            search(nums,target,temp,l,m-1);
	            search(nums,target,temp,m+1,h);
	        }
	    }
}

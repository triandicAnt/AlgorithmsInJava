/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class FindPeak {
	  public int findPeakElement(int[] nums) {
	        if(nums==null|| nums.length==0)
	            return -1;
	            
	        int l = 0;
	        int h = nums.length-1;
	        //return findPeak(nums,l,h);
	        return find(nums,l,h);
	    }
	    
	    public int findPeak(int [] nums, int l, int h){
	        if(l>h)
	            return -1;
	        while(l+1<h){
	            int m = (l+h)/2;
	            if(m-1>=0){
	                
	                if(nums[m-1]<nums[m] && nums[m]> nums[m+1])
	                    return m;
	                int x = findPeak(nums,l,m-1);
	                if(x!=-1)
	                    return x;
	                else
	                    return findPeak(nums,m+1,h);
	            }
	        }
	        if (nums[l] > nums[h]) {
	            return l;
	        } else {
	            return h;
	        }
	        //return -1;
	    }
	    public int find(int nums[], int l, int h){
	        
	        while(l+1<h){
	            int m = l+(h-l)/2;
	            if(nums[m-1]<nums[m]){
	                if(nums[m]>nums[m+1])
	                    return m;
	                else
	                    l=m;
	            }else{
	                if(nums[m+1]>nums[m]){
	                    l=m;
	                }else{
	                    h=m;
	                }
	            }
	        }
	        if(nums[l]>nums[h])
	            return l;
	        else
	            return h;
	    }
}

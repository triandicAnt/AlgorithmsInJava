/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class WiggleSubsequence {

	  //time - O(n^2) , space O(n)
	   /* public int wiggleMaxLength(int[] nums) {
	        if(nums==null||nums.length==0)
	            return 0;
	        if(nums.length==1)
	            return 1;
	        int n = nums.length;
	        int []up = new int [n];
	        int []down = new int [n];
	        
	        for(int i=1;i<n;i++){
	            for(int j=0;j<i;j++){
	                // check 
	                if(nums[i]>nums[j])
	                    //update up wiggle
	                    up[i] = Math.max(up[i],down[j]+1);
	                else if(nums[i]<nums[j])
	                    //down wiggle ,update it
	                    down[i] = Math.max(down[i],up[j]+1);
	            }
	        }
	        return Math.max(up[n-1],down[n-1])+1;
	    }*/
	    // time O(n), space O(n)
	   /* public int wiggleMaxLength(int[] nums) {
	        if(nums==null||nums.length==0)
	            return 0;
	        if(nums.length==1)
	            return 1;
	        int n = nums.length;
	        int []up = new int [n];
	        int []down = new int [n];
	        
	        for(int i=1;i<n;i++){
	           if(nums[i]>nums[i-1]){
	                up[i] = down[i-1]+1;
	                down[i] = down[i-1];    
	           }
	            else if(nums[i]<nums[i-1]){
	                down[i] = up[i-1]+1;
	                up[i] = up[i-1];
	            }
	            else{
	                up[i] = up[i-1];
	                down[i] = down[i-1];
	            }
	        }
	        return Math.max(up[n-1],down[n-1])+1;
	    }*/
	    
	    // time O(n) space O(1)
	     public int wiggleMaxLength(int[] nums) {
	        if(nums==null||nums.length==0)
	            return 0;
	        if(nums.length==1)
	            return 1;
	        int n = nums.length;
	       int up=0;
	        int down=0;
	        
	        for(int i=1;i<n;i++){
	           if(nums[i]>nums[i-1]){
	                up = down+1;
	           }
	            else if(nums[i]<nums[i-1]){
	                down = up+1;
	            }
	        }
	        return Math.max(up,down)+1;
	    }
}


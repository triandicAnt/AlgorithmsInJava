/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class PartitionEqualSubset {
	 public boolean canPartition(int[] nums) {
	        // Arrays.sort(nums);
	        // int l = nums.length;
	        // for(int i=l-1;i>0;i--){
	        //     int s1=0;
	        //     for(int j=i;j<l;j++){
	        //         s1+=nums[j];
	        //     }
	        //     int s2 = 0;
	        //     for(int k = i-1;k>=0;k--){
	        //         s2+=nums[k];
	        //     }
	        //     if(s1==s2)
	        //         return true;
	        // }
	        // return false;
	        
	        int sum = 0;
	        for(int a:nums){
	            sum+=a;
	        }
	        int l = nums.length;
	        if(sum%2!=0)
	            return false;
	        int half = sum/2;
	        
	        boolean temp[][] = new boolean [l+1][half+1];
	        for(int i=0;i<=l;i++){
	            temp[i][0]= true;
	        }
	        
	        for(int i=1;i<=l;i++){
	            
	            for(int j =1;j<=half;j++){
	                // if(i==0){
	                //     if(j==nums[i]){
	                //         temp[i][j]=true;
	                //     }else{
	                //         temp[i][j] = false;
	                //     }
	                // }
	               // else{
	                if(j<nums[i-1]){
	                    temp[i][j] = temp[i-1][j];
	                }else{
	                    temp[i][j] = temp[i-1][j] || temp[i-1][j-nums[i-1]];
	                }
	              //  }
	            }
	        }
	        return temp[l][half];
	        
	    }
}

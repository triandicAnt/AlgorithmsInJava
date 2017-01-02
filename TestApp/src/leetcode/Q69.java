/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class Q69 {
	 public int mySqrt(int x) {
	        if(x==0 || x == 1)
	            return x;
	        int low = 1;
	        int high = Integer.MAX_VALUE;
	        while(true){
	            int mid = low + (high-low)/2;
	            // if(mid == x/mid){
	            //     return mid;
	            if(mid>x/mid){
	                high = mid-1;
	            }else{
	                if (mid + 1 > x/(mid + 1))
	                    return mid;
	                low = mid+1;
	            }
	        }
	        //return low-1;
	    }
}

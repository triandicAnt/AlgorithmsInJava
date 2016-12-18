/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class LengthOfLIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(a));
	}
	public static int lengthOfLIS(int[] nums) {
        int arr [] = new int [nums.length];
        Arrays.fill(arr,1);
        for(int i =1; i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && arr[j]+1 >arr[i]){
                    arr[i] = arr[j]+1;    
                    System.out.println("---"+nums[i]+ " "+ nums[j] + " " +arr[i] +  " "+ arr[j]);

                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int max = 0;
        for(int a:arr){
            if(a>max)
                max=a;
        }
        return max;
    }
}

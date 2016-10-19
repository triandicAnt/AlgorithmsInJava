/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class ProdutExceptItself {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {1,0};
		System.out.println(Arrays.toString(productExceptSelf(a)));

	}
	public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length<1)
            return nums;
        int mul =1;
        int i =0;
        int count = 0;
        boolean flag = false;
        for(int x =0; x<nums.length;x++){
            if(nums[x] == 0){
                i = x;
                count ++;
            }else{
                mul = mul*nums[x];
            }
        }
       // int arr = new int [nums.length];
        if(count >1){
            for(int y=0;y<nums.length;y++){
                nums[y]=0;
            }
            return nums;
        }
        if(count == 1){
            //System.out.println("Here" + i + " "+ mul);
            nums[i] = mul;
            //System.out.println("1 ---"+Arrays.toString(nums));
            
            for(int p =0; p<nums.length; p++){
                if(p!=i){
                    nums[p]=0;
                }
            }
           // System.out.println("---"+Arrays.toString(nums));
            return nums;
        }
        int z =0;
        for(int a : nums){
            nums[z++] = mul/a;
        }
        return nums;
        
    }

}

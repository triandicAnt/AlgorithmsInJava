package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1, 2, 1, 3, 2, 5};
		System.out.println(Arrays.toString(singleNumber(nums)));

	}
	 public static int[] singleNumber(int[] nums) {
	        if(nums == null || nums.length<1)
	            return null;
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int a: nums){
	            if(map.containsKey(a)){
	                map.put(a,map.get(a)+1);
	            }else{
	                map.put(a,1);
	            }
	        }
	        int x [] = new int [2];
	        int i =0;
	        for(Map.Entry e: map.entrySet()){
	            int a =(int) e.getValue();
	            if(a==1){
	                x[i++] = (int)e.getKey();
	            }
	        }
	        return x;
	    }

}

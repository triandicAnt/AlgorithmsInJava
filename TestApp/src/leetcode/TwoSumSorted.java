package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,0,0};
		System.out.println(Arrays.toString(twoSum(a, 0)));

	}
	 public static int[] twoSum(int[] numbers, int target) {
	        if(numbers.length<2){
	            return null;
	        }
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int i=0;
	        
	        for(int a: numbers){
	            map.put(a,++i);
	        }
	        int []x = new int [2];
	        int y =0;
	        for(int b : numbers){
	            if(b==target-b){
	                 x[0] = y;
	                x[1] = map.get(target-b);
	            }
	            else if(map.containsKey(target-b)){
	                x[0] = map.get(b);
	                x[1] = map.get(target-b);
	            }
	            y++;
	        }
	        Arrays.sort(x);
	        return x;
	    }

}

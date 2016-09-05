package array;

import java.util.HashMap;

public class SubArrayWithGivenSum {
		public static void main(String[] args) {
			int arr[] = new int []{1, 4, 20, 3, 10, 5};
			findSubArrayWithSum(arr, 33);
			int arr1[] = new int [] {1, 4, 0, 0, 3, 10, 5};
			int arr2[] = new int [] {1, 4};
			int arr3[] = new int [] {10, 2, -2, -20, 10};
			findSubArrayWithSum(arr1, 7);
			findSubArrayWithSum(arr2, 0);
			findSubArrayWithSum(arr3, -10);

			
		}
		/**
		 * Find subarray with given sum
		 *  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
			Ouptut: Sum found between indexes 2 and 4

			Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
			Output: Sum found between indexes 1 and 4

			Input: arr[] = {1, 4}, sum = 0
			Output: No subarray found
			Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
			Ouptut: Sum found between indexes 0 to 3
		 */
		
		static void findSubArrayWithSum(int [] arr, int sum){
			
			HashMap<Integer, Integer> map = new HashMap<>();
			int curSum = 0;
			for (int i = 0; i < arr.length; i++) {
				curSum  = curSum + arr[i];
				if(curSum == sum){
					System.out.println("found at index " + "0 to "+ i);
					return;
				}
				if(map.containsKey(curSum-sum)){
					System.out.println("found at index " + (map.get(curSum-sum)+1) + " to "+ i);
					return;
				}
				map.put(curSum, i);
				
			}
			System.out.println("not found!");
		}
}

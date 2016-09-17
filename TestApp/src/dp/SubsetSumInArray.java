package dp;

import java.util.Arrays;

public class SubsetSumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set[] = {3, 34, 4, 12, 5, 2}, sum = 9
		int set[] = {3, 34, 4, 12, 5, 2};
		System.out.println(checkSubsetSum(set, 9, 6));
		System.out.println(isSubsetSum(set, 9, 6));
		
		int a [] = {1,2,3,4,5,6};
		int sum = 10;
//		allSubSet(a, 0, 0, sum, "");
		printAll(4, 3, "");
		
		

	}
	/**
	 * Exponential
	 * if sum is 0 then return true
	 * if n==0 and sum is not 0 return false
	 * if last element of arr is greater than sum check with excluding last element
	 * if any of the following cases is true:
	 * 		1. sum-arr[n-1] is present in including last element
	 * 		2. sum-arr[n-1] is present in excluding last element
	 */
	
	static boolean checkSubsetSum(int [] arr, int sum, int n){
		if(sum == 0)
			return true;
		if(n==0 && sum!= 0)
			return false;
		if(arr[n-1]>sum)
			return checkSubsetSum(arr, sum, n-1);
		return checkSubsetSum(arr, sum-arr[n-1], n) || checkSubsetSum(arr, sum-arr[n-1], n-1);
	}
	
	// DP
	/**
	 * create a boolean array subSet[sum+1][n+1] and fill values in bottom up
	 */
	
	static boolean isSubsetSum(int arr[], int sum, int n){
		if(sum == 0)
			return true;
		if( n==0 && sum!=0)
			return false;
		boolean subSet[][] = new boolean[sum+1][n+1];
		
		//if sum is 0 all values will be T in that row
		for(int i=0; i<=n;i++)
			subSet[0][i] = true;
		
		// if n ==0 and sum is not zero then all values will be false in that col
		for(int i=1; i<=sum ; i++)
			subSet[i][0] = false;
		
		// fill table
		for(int i=1; i<=sum;i++){
			for(int j =1; j<=n;j++){
				subSet[i][j] = subSet[i][j-1];
				if(i>=arr[j-1]){
					// check for the previous values
					subSet[i][j] = subSet[i][j] || subSet[i-arr[j-1]][j-1];
				}
			}
		}
		return subSet[sum][n];
	}
	
	/**
	 * all subsets with a given sum (non repeating numbers)
	 * 
	 */
	
	static void allSubSet(int []arr, int index,int cur,  int sum, String result){
		if(arr.length < index || cur>sum)
			return;
		for(int i = index; i< arr.length; i++){
			if(cur + arr[i] == sum){
				System.out.println(result + " " + arr[i]);
			}
			else if(cur + arr[i]<sum){
				allSubSet(arr, i+1, cur+arr[i], sum, result + " " + arr[i]);
			}
		}
	}
	
	/**
	 * Print all unique partition
	 */
	static void printAll(int target, int maxValue, String suffix){
		if(target == 0)
			System.out.println(suffix);
		else{
			if(maxValue >1)
				printAll(target, maxValue-1, suffix);
			if(maxValue<=target)
				printAll(target-maxValue, maxValue, maxValue + " " +suffix);
		}
	}
}

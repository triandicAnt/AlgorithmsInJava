package recursion;

public class AllSubsetWithSum {
	
	public static void main(String[] args) {
		int a [] = {1,2,3,4,5,6};
		int sum = 10;
		allSubSet(a, 0, 0, sum, "");
		printAll(4, 3, "");
		//findAllSubsets(a, 0, 0, sum, "");
		
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
	
	/**
	 * find all subset containing unique numbers which add up to a given sunm
	 * 
	 * 	 * Test 1 - Print repeating number ( Fails) 2,2,2,4
	 *      Working on fix
	 * 	 * Test 2 - change the value of i starting from 0 to index (Fails)
	 *		Prints duplicate entries like 4,6 and 6,4
	 *		Working on fix
	 *		Resolution : initial check cur=a[index]>sum was wrong
	 *					 Changed it to cur>sum
	 *					 pass i+1 - does not print duplicates
	 *					 pass index+1 - prints duplicates 
	 *
	 */
	
	public static void findAllSubsets(int []a, int index, int cur, int sum, String result){
		// if the index is greater than the array size or the the cur+a[index] is greater than the sum ; simple return
		if(index> a.length || cur >sum){
			return;
		}
		// for each element in the array check (a[i] + cur) value
		// if it is equal to sum then print the result
		// if the cur + a[i]<sum then increment the index value
		for(int i=index; i<a.length; i++){
			if(a[i]+cur == sum){
				System.out.println(result + " " + a[i]);
			}else if(cur + a[i]<sum){
				findAllSubsets(a, i+1, cur + a[i], sum, result + " "+ a[i]);
			}
		}
	}
	
}

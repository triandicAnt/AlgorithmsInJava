package recursion;

public class AllSubsetWithSum {
	
	public static void main(String[] args) {
		int a [] = {1,2,3,4,5,6};
		int sum = 10;
//		allSubSet(a, 0, 0, sum, "");
		printAll(4, 3, "");
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

import java.util.Arrays;

public class CandidateSum {

	public static void main(String[] args) {
		/**
		 * possible scores: [3,5,3,3,5] (duplicates, unsorted, there may be a lot of possible score, not necessarily only 3 and 5)
			Candle score: 6, yes
			Candidate score: 11, yes
			Candle score score: 7, no
		 *
		 */
		int a [] = {3,5,3,3,5};
		System.out.println(sum(a,6));
		System.out.println(sum(a,11));
		System.out.println(sum(a,7));
		System.out.println("---------------------");
		System.out.println(exists(a,6));
		System.out.println(exists(a,11));
		System.out.println(exists(a,7));
		
	}
	
	public static boolean sum(int[] a , int target){
		if(a==null || a.length == 0 || target==0)
			return false;
		Arrays.sort(a);
		return sum(a, target, 0);
	}
	public static boolean sum(int [] a,int target,int start){
		if(target==0)
			return true;
		if(target<0)
			return false;
		for(int i = start; i<a.length;i++){
			if(sum(a, target-a[i], i+1))
				return true;
		}
		return false;
	}
	
	public static boolean exists(int a[], int target){
		if(a==null || a.length == 0 || target==0)
			return false;
		boolean [] temp = new boolean[target+1];
		temp[0] = true;
		for(int s : a){
			for(int k = s;k<=target;k++){
				temp[k] |= temp[k-s];
			}
		}
		return temp[target];
	}
}

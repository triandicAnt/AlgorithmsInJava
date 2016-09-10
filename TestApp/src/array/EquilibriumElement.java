package array;

public class EquilibriumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {-1,3,-4,5,1,-6,2,1};
		
		System.out.println(findEquilibrium(a));

	}
	/**
	 * an index i such that the left part sum is equal to right part sum
	 * @param a
	 * @return
	 */
	static int findEquilibrium(int []a){
		if(a == null)
			return -1;
		int total = 0;
		int sumSoFar = 0;
		for(int i:a){
			total+=i;
		}
		if(sumSoFar == total)
			return 0;
		sumSoFar = a[0];
		for(int i = 1; i<a.length;i++){
			if(sumSoFar == total - sumSoFar - a[i]){
				return i;
			}
			sumSoFar += a[i];
		}
		return -1;
	}
}

package dp;

import java.util.Arrays;

public class CheckArthimeticProgression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 7, 10, 15, 27, 29};
		System.out.println(checkForThree(arr));
		int set1[] = {1, 7, 10, 13, 14, 19};
		System.out.println(countAPInArray(set1));
	    int set2[] = {1, 7, 10, 15, 27, 29};
		System.out.println(countAPInArray(set2));
	    int set3[] = {2, 4, 6, 8, 10};
		System.out.println(countAPInArray(set3));

	}
	
	static boolean checkForThree(int [] arr){
		int n = arr.length;
		int i,j,k =0;
		for(j =1; j< n-1; j++){
			i = j-1;
			k = j+1;
			while(i>=0 && k<n){
				if(arr[i] + arr[k] == 2*arr[j])
					return true;
				else if (arr[i] + arr[k] > 2*arr[j])
					i--;
				else{
					k++;
				}
					
			}
		}
		return false;

	}
	
	static int countAPInArray(int []arr){
		int n =arr.length;
		if(n<=2)
			return n;
		int i,j,k = 0;
		int max = 2;
		int temp[][] = new int [n][n];
		for(int [] a: temp)
			Arrays.fill(a, 2);
		for(j = n-2; j>=1; j--){
			// then length of AP from k to j is 2, if we have an ap from j to i then the max length will be [j][k] +1
			i = j-1;
			k = j+1;
			while(i>=0 && k<n){
				if(arr[i]+arr[k] == 2*arr[j]){
					temp[i][j] = temp[j][k] + 1;
					// update the max value
					if(max<temp[i][j])
						max = temp[i][j];
					i--;
					k++;
				} // if less than increment k
				else if(arr[i] + arr[k]<2*arr[j]){
					k++;
				}// else decrement i
				else{
					i--;
				}
				
			}
		}
		return max;
	}

}

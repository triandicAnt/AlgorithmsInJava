package random;

import java.util.Arrays;

public class SortZeroAndOnes {

	public static void main(String[] args) {
		
		int [] a = {0,1,0,0,1,0,1,0,1,1,0,0,1};
		System.out.println(Arrays.toString(sortArray(a)));
	}
	
	static int[] sortArray(int [] arr){
		int i=0;
		int j= arr.length-1;
		for(int x = 0; x<arr.length;x++){
			if(arr[x]==0){
				i++;
			}else{
				break;
			}
		}
		for(int y = arr.length-1; y>=0;y--){
//			System.err.println(y);
			if(arr[y]==1){
				j--;
			}else{
				break;
			}
		}
		System.out.println(i + " " + j );
		while(i<j){
			if(arr[i]==1){
				swap(arr, i , j);
				if(arr[i]==0)
					i++;
				if(arr[j]==1)
					j--;
			}else{
				i++;
			}
		}
		return arr;
	}
	
	static void swap(int [] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}

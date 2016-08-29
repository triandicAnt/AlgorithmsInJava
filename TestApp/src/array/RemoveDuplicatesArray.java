package array;

import java.util.Arrays;

public class RemoveDuplicatesArray {
	public static void main(String[] args) {
		int [] a = {1,2,1,3,1};
		int [] b = {1,1,1,1,1};
		int [] c = {1,2,3,4,5};
		System.out.println(Arrays.toString(removeDuplicates(a)));
		System.out.println(Arrays.toString(removeDuplicates(b)));
		System.out.println(Arrays.toString(removeDuplicates(c)));

	}
	
	public static int[] removeDuplicates(int [] a){
		if (a.length <= 1)
			return a;
		int n = a.length;
		int nL = 1;
		for(int i = 0; i< n ; i++){
			int j = 0;
			for(j = 0;j<nL;j++){
				if(a[i] == a[j])
					break;
			}
			if (j == nL)
				a[nL++] = a[i];
		}
		for(int i= nL; i< n;i++)
			a[i] = 0;
		return a;
	}
}

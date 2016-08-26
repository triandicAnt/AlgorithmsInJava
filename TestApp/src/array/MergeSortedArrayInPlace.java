package array;
import java.util.Arrays;
public class MergeSortedArrayInPlace {

	public static void main(String[] args) {
		int a1[] = {1,3,5};
		int[] a2 = new int[6];
		a2[0] = 2;
		a2[1] = 4;
		a2[2] = 6;
		System.out.println(Arrays.toString(mergeArray(a1, a2, 3, 3)));
		System.out.println(Arrays.toString(sortArrayInPlace(new int[] {0,0,1,1,0,1,0,0,1})));
		
	}
	
	// a1 = [1,3,5]
	// a2 = [2,4,6,,,]
	
	// result [1,2,3,4,5,6]
	
	public static int[] mergeArray(int [] a1, int [] a2, int l1, int l2){
		
		int i = l1-1;
		int j = l2-1;
		int r = l1+l2-1;
		
		while(i>=0 || j>=0){
			if (j < 0 || (i >= 0 && a1[i] >= a2[j])) {
				a2[r--] = a1[i--];
			}
			else{
				a2[r--] = a2[j--];
			}
		}
		return a2;
		
	}
	
	// sort array containing only 0s and 1s in place and in order
	//[1,0,0,1,1,1,0]
	// in place
	static int [] sortArrayInPlace(int [] a){
		int sum = 0;
		for (int i:a){
			sum+= i;
		}
		for(int i = 0; i<a.length-sum; i++){
			a[i] = 0;
		}
		for(int i = a.length-sum; i< a.length; i++){
			a[i] = 1;
		}
		return a;
	}
	// in order
	//??
	
	
}

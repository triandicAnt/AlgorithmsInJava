package array;
import java.util.Arrays;
public class MergeSortedArrayInPlace {

	public static void main(String[] args) {
		int a1[] = {1,3,5,7};
		int[] a2 = new int[7];
		a2[0] = 2;
		a2[1] = 4;
		a2[2] = 6;
		//System.out.println(Arrays.toString(mergeArray(a1, a2, 3, 3)));
		System.out.println(Arrays.toString(mergeSortedArray1(a1, a2, 4, 3)));
		//System.out.println(Arrays.toString(sortArrayInPlace(new int[] {0,0,1,1,0,1,0,0,1})));
		//System.out.println(binarySearchRotated(0, 7, new int []{6, 7,8,1,2,3,4,5},8));
		
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
	
	/**
	 * find an element in rotated sorted array
	 */
	static int binarySearchRotated(int l, int h, int[] a, int e){
		if(a.length == 0)
			return -1;
		if (a.length == 1 && a[0] == e)
			return 0;
		int m = (l+h)/2;
		if (l==h && a[l]!=e)
			return -1;
		if (e == a[m])
			return m;
		boolean flag = false;
		if(a[h] > a[m])
			flag = true;
		if (flag){
			if(e > a[m] && e <= a[h]){
				 return binarySearchRotated(m+1, h, a, e);
			}
			else{
				return  binarySearchRotated(l, m-1, a, e);
			}
		}
		else{
			 return binarySearchRotated(l, m-1, a, e);
		}
		
	}
	
	static int [] mergeSortedArray1(int [] a1, int []a2, int l1, int l2){
		if(l1<=0){
			return a2; 
		}
		if(l2<=0){
			return a1;
		}
		int r = l1+l2-1;
		l1 = l1-1;
		l2 = l2-1;
		while(l1>=0 && l2>=0){
			if(a1[l1] >= a2[l2]){
				a2[r] = a1[l1];
				r = r-1;
				l1 = l1-1;
			}else{
				a2[r] = a2[l2];
				r = r-1;
				l2 = l2-1;
			}
		}
		if(l1>=0){
			while(l1>=0){
				a2[r] = a1[l1];
				r = r-1;
				l1 = l1-1;
			}
		}
		else if(l2>=0){
			while(l2>=0){
				a2[r] = a2[l2];
				r = r-1;
				l2 = l1-2;
			}
		}
		return a2;
	}
	
}

package array;
import java.io.IOException;
 
 
public class CountComp {
 
	static long noOfComparisons;
	public static void main(String args[]) throws IOException {
 
		int A[] = {3,2,5,4,1,7,0,9};
 
		QuickSort(A,0,A.length-1);
		for(int i : A){
			System.out.print(i+" ");
		}
 
		System.out.println(noOfComparisons);
 
	}
 
	private static void QuickSort(int[] a, int l, int r) {
 
		int pivot;
		if(r>l){
			add(r-l);
		pivot =Partition(a,l,r);
 
		QuickSort(a, l, pivot-1);
		QuickSort(a, pivot+1, r);
		}
		
	}
 
	private static void add(int i) {
		noOfComparisons+=i;
 
	}
 
	private static int Partition(int[] a, int l, int r) {
 
		int m = (l+r)/2;
		Swap(a,l,m);
 
		int p=a[l];
		int i =l+1;
 
		for(int j=l+1;j<=r;j++){
			if(a[j]<p){
				Swap(a,j,i);
				i++;
			}
		}
		Swap(a, l, i-1);
		return (i-1);
	}
 
 
 
	private static void Swap(int[] a, int i, int j) {
 
		int temp =a[j];
		a[j]=a[i];
		a[i]=temp;
	}
}
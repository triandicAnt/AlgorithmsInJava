/**
 * 
 */
package com.datastructure;

/**
 * @author Sudhansu
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int []{5,1,3,7,2,9,4,6};
		QuickSort q = new QuickSort();
		q.printArray(a);
		//q.swap(a,0, 1);
		q.quickSort(a, 0, a.length-1);
		q.printArray(a);
	}
	
	int partition(int array[], int l, int r){
		int p = array[l];
		int i = l+1;
		for (int j = l+1; j <= r; j++) {
			if(array[j]<p){
				swap(array,i,j);
				i=i+1;
			}
			
		}
		swap(array,i-1,l);
		return i-1;
	}
	
	void swap(int []array, int a, int b){
		int temp = array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	void quickSort(int[] array, int l, int r){
		if(l<r){
			int p = partition(array, l, r);
			quickSort(array, l, p-1);
			quickSort(array, p+1, r);
		}
		
	}
	void printArray(int [] array){
		for(int i: array){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}

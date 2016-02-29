/**
 * 
 */
package com.datastructure;

import java.util.ArrayList;

/**
 * @author Sudhansu
 *
 */
@SuppressWarnings("all")
class MaxHeap{
	int size;
	ArrayList array;
}
@SuppressWarnings("all")

class MinHeap{
	int size;
	ArrayList array;
}
@SuppressWarnings("all")
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList array = new ArrayList (){{
			add(2);
			add(4);
			add(1);
			add(6);
			add(9);
			add(7);
			add(5);
		}};
		HeapSort hp = new HeapSort();
		hp.printArray(array);
		//hp.swap(array,0,1);
		hp.heapSort(array, array.size());
		hp.printArray(array);
		
	}


	private MaxHeap createAndBuildHeap(ArrayList array, int size){
		MaxHeap mh = new MaxHeap();
		mh.size = size;
		mh.array = array;
		
		for (int i = (mh.size-2)/2; i>=0; i--) {
			maxHeapify(mh,i);
		}
		return mh;
	}
	
	private void maxHeapify(MaxHeap mh, int index){
		int l = index;
		int left = 2*index +1;
		int right = 2*index +2;
		if(left<mh.size && (int)mh.array.get(left)>(int)mh.array.get(l))
			l = left;
		if(right<mh.size && (int)mh.array.get(right)>(int)mh.array.get(l))
			l = right;
		if(l!=index){
			swap(mh.array,l,index);
			maxHeapify(mh, l);
		}
	}
	private void minHeapify(MaxHeap mh, int index){
		int l = index;
		int left = 2*index +1;
		int right = 2*index +2;
		if(left<mh.size && (int)mh.array.get(left)<(int)mh.array.get(l))
			l = left;
		if(right<mh.size && (int)mh.array.get(right)<(int)mh.array.get(l))
			l = right;
		if(l!=index){
			swap(mh.array,l,index);
			maxHeapify(mh, l);
		}
	}
	void swap(ArrayList array, int a , int b){
		Object temp = array.get(a) ; 
		array.set( a, array.get(b)) ;
		array.set( b, temp ) ; 
	}
	
	void heapSort(ArrayList array, int size){
		MaxHeap mh = createAndBuildHeap(array, size);
		while(mh.size>1){
			swap(mh.array,0,mh.size-1);
			--mh.size;
			maxHeapify(mh, 0);
		}
	}
	void printArray(ArrayList array){
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
}
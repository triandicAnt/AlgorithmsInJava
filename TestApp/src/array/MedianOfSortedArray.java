package array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] a1 = {1,3};
//		int [] a2 = {2}; 
//		getMedianOfSortedArray(a1, a2);
//		System.out.println("-----");
		
//		int []a3 = {1,2};
//		int []a4 = {3,4};
//		getMedianOfSortedArray(a3, a4);
		
//		int []a5 = {1,2,5};
//		int []a6 = {3,4,6};
//		System.out.println(getMedianOfSortedArray(a5, a6));

		

	}
	
	/**
	 * https://leetcode.com/problems/median-of-two-sorted-arrays/
	 */
	
	public static double getMedianOfSortedArray(int [] a1, int [] a2){
		// handle edge cases in better way
		if(a1.length==0 && a2.length==0)
			return 0.0;
		if(a1.length==0){
			if(a2.length%2==0){
				int mid = a2.length/2;
				return (double)(a2[mid-1]+a2[mid])/2.0;
			}else{
				return a2[a2.length/2];
			}
		}
		if(a2.length==0){
			if(a1.length%2==0){
				int mid = a1.length/2;
				return (double)(a1[mid-1]+a1[mid])/2.0;
			}else{
				return a1[a1.length/2];
			}
		}
		
		int size = a1.length + a2.length;
		
		// create two PQs one min and other Max
		
		//Min
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		//Max
		 PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		 
		 /**
		  * add the greater of the first elements of both array in minPQ and smaller in maxPQ
		  * for the rest of the elements
		  * if the element is greater than the minPQ top ..add in the minPQ
		  * else if the element is greater than the maxPQ top ... add in the maxPQ 
		  */
		 
		 int min = Math.min(a1[0], a2[0]);
		 maxPQ.offer(min);
		 int max = Math.max(a1[0], a2[0]);
		 minPQ.offer(max);
		 System.out.println(minPQ);
		 System.out.println(maxPQ);
		 int i =1, j=1;
		 while(i<a1.length || j<a2.length){
			 int x = 0;
			 if(i<a1.length && j<a2.length){
				 if(a1[i]<a2[j]){
					 x = a1[i];
					 i++;
				 }else{
					 x = a2[j];
					 j++;
				 }
			 }else if(i<a1.length){
				 x = a1[i];
				 i++;
			 }else{
				 x = a2[j];
				 j++;
			 }
			
			 if(x>0){
			 
				 if(x > minPQ.peek()){
					 minPQ.offer(x);
				 }else{
					 maxPQ.offer(x);
				 }

				 // rearrange the PQs if the difference of sizes are greater than or equal to 2
				 int s1 = minPQ.size();
				 int s2 = maxPQ.size();
				 int ms = Math.abs(s1-s2);
				 if(ms>=2){
					 if(s1>s2){
						 int e = minPQ.poll();
						 maxPQ.offer(e);
					 }else{
						 int e = maxPQ.poll();
						 minPQ.offer(e);
					 }
				 }
			 }
		 }
		 
		 System.out.println(minPQ);
		 System.out.println(maxPQ);
		 if(size%2==0){
			 return (float)(minPQ.peek() + maxPQ.peek())/2.0f;
		 }else{
			 if(minPQ.size()>maxPQ.size())
				 return minPQ.peek();
			 else
				 return maxPQ.peek();
		 }
		 
		 
	}
	
}

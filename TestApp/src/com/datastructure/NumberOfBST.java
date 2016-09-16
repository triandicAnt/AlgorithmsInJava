package com.datastructure;

public class NumberOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countTree(1));
		System.out.println(countTree(2));
		System.out.println(countTree(3));
		System.out.println(countTree(4));
		System.out.println(countTree(5));



	}
	// Count number of bs tree created from a given number,
		/**
		 * 
		 * @param num
		 * @return
		 */
		static protected int countTree(int num){
			if(num==0 || num ==1)
				return 1;
			int sum = 0;
			for(int i = 1;i<=num;i++){
				int leftCount = countTree(i-1);
				int rightCount = countTree(num-i);
				sum = sum + leftCount*rightCount;
			}
			return sum;
		}

}

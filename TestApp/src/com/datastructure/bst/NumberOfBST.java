package com.datastructure.bst;

public class NumberOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countTree(1));
		System.out.println(countTree(2));
		System.out.println(countTree(3));
		System.out.println(countTree(4));
		System.out.println(countTree(5));



	}
	
	/**
	 * 
	 * The number of BSTs possible with n nodes is given by the Catalan Number
Cn=1n+1(2nn)=(2n)!/(n+1)!n!

The number of unlabeled binary trees is the same as the number of BSTs possible

The number of labelled binary trees possible is given by

Cn=(1/n+1)(2n n)×n!=(2n)!/(n+1)!
	 */
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

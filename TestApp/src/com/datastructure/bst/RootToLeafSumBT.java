/**
 * 
 */
package com.datastructure.bst;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class RootToLeafSumBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.left.right.left = new BTNode(8);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.right.right.left = new BTNode(10);
		root.right.left.right = new BTNode(9);

//		System.out.println(hasPathSumTillRoot(root, 17));
//		System.out.println(hasPathSumTillRoot(root, 13));
//		System.out.println(hasPathSumTillRoot(root, 25));
//		System.out.println(hasPathSumTillRoot(root, 10));
//		System.out.println(hasPathSumTillRoot(root, 11));
//		System.out.println(hasPathSumTillRoot(root, 12));
//		System.out.println(hasPathSumTillRoot(root, 14));
		
//		System.out.println(hasPathSumBeforeRoot(root, -1)); //T
//		System.out.println(hasPathSumBeforeRoot(root, 2)); //T
//		System.out.println(hasPathSumBeforeRoot(root, 3)); //T
//		System.out.println(hasPathSumBeforeRoot(root, 11)); //T
//		System.out.println(hasPathSumBeforeRoot(root, 0)); //T
//		System.out.println(hasPathSumBeforeRoot(root, 1)); //F
//		System.out.println(hasPathSumBeforeRoot(root, 14)); //F
		
		int [] path = new int [100]; 
		printAllPathSum(root, 0, path);
		
//		BTNode root = new BTNode(3);
//		root.left = new BTNode(-5);
//		root.left.left = new BTNode(2);
//		root.left.right = new BTNode(4);
//		root.left.right.left = new BTNode(8);
//		root.left.right.left.left = new BTNode(1);
//		root.left.right.left.right = new BTNode(19);
//		root.left.right.right = new BTNode(11);
//		root.left.right.right.right = new BTNode(18);
//		
//		root.right = new BTNode(0);
//		root.right.left = new BTNode(-4);
//		root.right.right = new BTNode(7);
//		root.right.right.left = new BTNode(9);
//		int [] path = new int [height(root)];
//		printPathSumAnywhere(root, 7, 0, path);

	}
	
	static int height(BTNode root){
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right)+1;
	}
	
	static boolean hasPathSumTillRoot(BTNode root, int sum){
		if(root==null && sum ==0)
			return true;
		if(root==null && sum !=0)
			return false;
		int subSum = sum-root.data;
		return hasPathSumTillRoot(root.left, subSum) || hasPathSumTillRoot(root.right, subSum);
	}
	static boolean hasPathSumBeforeRoot(BTNode root, int sum){
		if(root==null && sum ==0)
			return true;
		if(root==null && sum !=0)
			return false;
		
		int subSum = sum-root.data;
		// if the subSum becomes zero at any point before leaf, return true
		if(subSum == 0)
			return true;
		return hasPathSumBeforeRoot(root.left, subSum) || hasPathSumBeforeRoot(root.right, subSum);
	}
	
	static void printAllPathSum(BTNode root, int l, int [] path){
		if(root==null)
			return ;
		path[l] = root.data;
		if(root.left == null && root.right == null){
			System.out.println(Arrays.toString(path));
			return;
			
		}
		// if the subSum becomes zero at any point before leaf, return true
		printAllPathSum(root.left, l+1, path);
		printAllPathSum(root.right, l+1, path);
	}
	
	static void printPathSumAnywhere(BTNode root, int sum, int l, int [] path){
		if(root == null)
			return;
		path[l] = root.data;
		int curSum = 0;
		for (int i = l; i >= 0; i--) {
			curSum += path[i];
			if(curSum == sum){
				printArray(path, i, l);
			}
		}
		printPathSumAnywhere(root.left, sum, l+1, path);
		printPathSumAnywhere(root.right, sum, l+1, path);
					
	}
	static void printArray(int[] path, int start, int end){
		for(int i = start; i<=end; i++ ){
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

}

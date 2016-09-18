package com.datastructure.bst;

public class LeafToLeafMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BTNode root = new BTNode(-5);
		root.left = new BTNode(1);
		root.left.left = new BTNode(-6);
		root.left.left.left = new BTNode(9);
		root.left.left.right = new BTNode(10);
		root.left.right = new BTNode(5);
		root.left.right.left = new BTNode(-2);
		root.left.right.right = new BTNode(3);
		root.right = new BTNode(4);
		root.right.left = new BTNode(11);
		root.right.right = new BTNode(-2);
		root.right.right.left = new BTNode(7);
		root.right.right.right = new BTNode(-8);
		root.right.right.right.left = new BTNode(1);
		root.right.right.right.right = new BTNode(7);
		root.right.right.right.right.left = new BTNode(12);
		root.right.right.right.right.right = new BTNode(13);
	
		int x = maxSumLeaf(root);
		System.out.println(maxSum);

	}
	/**
	 * maximum path sum between two leaves
	 */
	static int maxSum = 0;
	static int maxSumLeaf(BTNode root){
		if (root == null)
			return 0;
		int left = maxSumLeaf(root.left);
		int right = maxSumLeaf(root.right);
		int curSum = left+right+root.data;
		if(curSum>maxSum)
			maxSum = curSum;
		return Math.max(left, right) + root.data;	
	}
}

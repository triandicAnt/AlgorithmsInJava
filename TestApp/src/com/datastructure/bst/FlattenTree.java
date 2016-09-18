package com.datastructure.bst;

public class FlattenTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(5);
		root.left.left = new BTNode(3);
		root.left.right = new BTNode(4);
		root.right.left = new BTNode(7);
		root.right.right = new BTNode(6);
		preOrder(root);
		System.out.println();
		BTNode root1 = flattenTree(root);
		System.out.println(root1 + "--");
		preOrder(root1);

	}
	
	static void preOrder(BTNode root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static BTNode flattenTree(BTNode root1){
		if(root1 == null)
			return null;
		BTNode root = root1;
		while(root!=null){
			// check root left exist or not
			if(root.left!= null){
				// find the right most node of the left subtree
				BTNode rightMost = root.left;
				while(rightMost.right != null){
					rightMost = rightMost.right;
				}
				// make the right of root to right of rightmost
				rightMost.right = root.right;
				// make the right of root to left of root
				root.right = root.left;
				// make left of root as null
				root.left = null;		
			}else{
				// go to right of root
				root = root.right;
			}
		}
		return root1;
	}

}

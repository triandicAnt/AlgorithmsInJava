package com.datastructure.bst;

public class PrintBoundaryTree {
	public static void main(String[] args) {
		
		/**
		 *    100
            /   \ 
          50     150
         / \      /
       24   57   130
      /  \    \    \
    12   30    60   132

e.g: the output should be 100, 50, 24, 12, 30, 57, 60, 130, 132, 150
		 */
		
		BTNode root = new BTNode(100);
		root.left = new BTNode(50);
		root.left.left = new BTNode(24);
		root.left.left.left = new BTNode(12);
		root.left.left.right = new BTNode(30);
		root.left.right = new BTNode(57);
		root.left.right.right = new BTNode(60);
		root.right = new BTNode(150);
		root.right.left = new BTNode(130);
		root.right.left.right = new BTNode(132);
		
		printBoundary(root);
		System.out.println();
		BTNode tree = new BTNode(20);
        tree.left = new BTNode(8);
        tree.left.left = new BTNode(4);
        tree.left.right = new BTNode(12);
        tree.left.right.left = new BTNode(10);
        tree.left.right.right = new BTNode(14);
        tree.right = new BTNode(22);
        tree.right.right = new BTNode(25);
        printBoundary(tree);
        /**
         * 20 8 4 10 14 25 22
	       20 8 4 10 14 25 22
         */
        
        /**
     1
   /    \
  2      3
 /  \   /  \
4    5 6    7
    /   \     \
   8     9     10
         */
		
        BTNode root1 = new BTNode(1);
        root1.left = new BTNode(2);
        root1.left.left = new BTNode(4);
        root1.left.right = new BTNode(5);
        root1.left.right.left = new BTNode(8);
        root1.right = new BTNode(3);
        root1.right.left = new BTNode(6);
        root1.right.left.right = new BTNode(9);
        root1.right.right = new BTNode(7);
        root1.right.right.right = new BTNode(10);
        System.out.println();
        printBoundary(root1);
        
        /**
         * 1, 2, 4, 8, 9, 10, 7, 3
         * 1, 2, 4, 8, 9, 10, 7, 3 
         */
	}
	 
	// print boundary wrapper
	
	static void printBoundary(BTNode root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		printLeft(root.left);
		printRight(root.right);
	}
	
	// print left
	static void printLeft(BTNode root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		printLeft(root.left);
		printChild(root.right);
	}
	
	// print child
	static void printChild(BTNode root){
		if(root == null)
			return;
		if(root.left == null && root.right == null)
			System.out.print(root.data + " ");
		printChild(root.left);
		printChild(root.right);
	}
	
	// print right
	static void printRight(BTNode root){
		if(root == null)
			return;
		printChild(root.left);
		printRight(root.right);
		System.out.print(root.data + " ");
	}
	
}

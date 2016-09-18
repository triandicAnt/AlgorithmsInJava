/**
 * 
 */
package com.datastructure.bst;

/**
 * @author Sudhansu
 *
 */
public class BinaryTreeProblems extends BinaryTree {

	/**
	 * @param args
	 */
//	BTNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeProblems bp = new BinaryTreeProblems();
		BinaryTree b = new BinaryTree();
		int []a = new int [] {1, 7, 5, 50, 40, 10};
		b.root = bp.constructBST(a);
		//System.out.println(b.root.data);
		//new BinaryTree().inOrder(b.root);
		
		BTNode root1 = new BTNode(10);
		root1.left = new BTNode(-2);
		root1.right = new BTNode(6);
		root1.left.left = new BTNode(8);
		root1.left.right = new BTNode(-4);
		root1.right.left = new BTNode(7);
		root1.right.right = new BTNode(5);
		new BinaryTree().inOrder(root1);
		System.out.println("");
		//bp.toSumTree(root1);
		bp.toSum(root1);
		new BinaryTree().inOrder(root1);
		
		
//		find level with max nodes
		BinaryTree bTree = new BinaryTree();
		BTNode root2;
		
        root2 = new BTNode(1);
        root2.left = new BTNode(2);
        root2.right = new BTNode(3);
        root2.left.left = new BTNode(4);
        root2.left.right = new BTNode(5);
        root2.right.right = new BTNode(8);
        root2.right.right.left = new BTNode(6);
        root2.right.right.right = new BTNode(7);
//        System.out.println();
//        System.out.println(bp.findLevelWithMaxNodes(root2));
//        System.out.println(bp.findLevelWithMaxNodes(root1));
        
        // remove all half nodes
        BTNode root3 = new BTNode(2);
        root3.left = new BTNode(7);
        root3.right = new BTNode(5);
        root3.left.right = new BTNode(6);
        root3.left.right.left = new BTNode(1);
        root3.left.right.right = new BTNode(11);
        root3.right.right = new BTNode(9);
        root3.right.right.left = new BTNode(3);
        
//        bTree.inOrder(root3);
//        System.out.println();
//        bTree.inOrder(bp.removeHalfNodes(root3));
        
        /**
         * 7 1 6 11 2 5 3 9
		 * 1 6 11 2 4
         */
        

	}

	// construct a tree from given post-order traversal 
	/**
	 * 
	 * @param a
	 * @return
	 */
	BTNode constructBST(int [] a){
		if(a==null)
			return null;
		return constructBSTRecursive(a, 0, a.length-1);
	}
	/**
	 * 
	 * @param nodes
	 * @param first
	 * @param last
	 * @return
	 */
	BTNode constructBSTRecursive(int [] nodes, int first, int last){
		if(first>last)
			return null;
		if(first == last)
			return new BinaryTree().createNode(nodes[first]);
		BTNode root = new BinaryTree().createNode(nodes[last]);
		int lastSmall = findLastSmall(nodes, first, last-1, root.data);
		root.left = constructBSTRecursive(nodes, first, lastSmall);
		root.right = constructBSTRecursive(nodes, lastSmall+1, last-1);
		return root;
	}
	/**
	 * 
	 * @param nodes
	 * @param first
	 * @param last
	 * @param value
	 * @return
	 */
	int findLastSmall(int[]nodes, int first, int last, int value){
		if(first>last || nodes[first]>value){
			return first -1;
		}
		while(first<last && nodes[last]>value){
			int mid = first +(last-first+1)/2;
			if(nodes[mid]>value)
				last = mid-1;
			else
				first = mid;
		}
		return last;
	}
	/**
	 *    	   10
           /      \
          -2        6
       /   \      /  \ 
     8     -4    7    5
     
               20(4-2+12+6)
           /      \
        4(8-4)      12(7+5)
       /   \      /  \ 
     0      0    0    0
	 */
	/**
	 * create a tosum tree from a binary tree.
	 * each node will be equal to the sum of left subtree and right subtree
	 * 
	 */
	int toSumTree(BTNode root){
		
		if (root == null){
			return 0;
		}
		int oldValue = root.data;
		root.data = toSumTree(root.left) + toSumTree(root.right);
		return root.data + oldValue;
	}
	/**
	 * 
	 *    1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7
	 */
	/**
	 * Level with maximum width in a binary tree
	 * 
	 *  */
	
	int findLevelWithMaxNodes(BTNode root){
		int h = new BinaryTree().heightOfTree(root);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= h; i++) {
			int w = getWidth(root, i);
			if(w>max){
				max = w; 
			}
		}
		return max;
	}
	/**
	 * find width/no. of nodes at a level
	 * @param root
	 * @param level
	 * @return
	 */
	int getWidth(BTNode root, int level){
		if(root == null){
			return 0;
		}
		if(level == 1){
			return 1;
		}
		else if(level >1){
			return getWidth(root.left, level-1) + getWidth(root.right, level-1);
		}
		return 0;
	}
	
	/**
	 * remove all the half nodes from a bt
	 */
	BTNode removeHalfNodes(BTNode root){
		if(root == null)
			return null;
		// preorder traversal
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		// if leaf return it
		if(root.left == null && root.right == null)
			return root;
		if(root.left == null)
			return root.right;
		if(root.right == null)
			return root.left;
		return root;
		
	}
	
	int toSum(BTNode root){
		if(root==null)
			return 0;
		int oldValue = root.data;
		int left = toSum(root.left);
		int right = toSum(root.right);
		
		if(root.left == null && root.right == null)
			root.data = 0;
		else
			root.data = left+ right;
		return oldValue + left+ right;
	}
	
}

// ref http://stackoverflow.com/questions/13167536/how-to-construct-bst-given-post-order-traversal


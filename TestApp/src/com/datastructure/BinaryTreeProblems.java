/**
 * 
 */
package com.datastructure;

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
		System.out.println(b.root.data);
		new BinaryTree().inOrder(b.root);

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
}

// ref http://stackoverflow.com/questions/13167536/how-to-construct-bst-given-post-order-traversal
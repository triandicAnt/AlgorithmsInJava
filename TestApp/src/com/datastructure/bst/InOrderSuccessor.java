package com.datastructure.bst;

public class InOrderSuccessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = new BTNode(15);
		root.left = new BTNode(10);
		root.left.left = new BTNode(8);
		root.left.left.left = new BTNode(6);
		root.left.right = new BTNode(12);
		root.left.right.left = new BTNode(11);
		root.right = new BTNode(20);
		root.right.left = new BTNode(17);
		root.right.left.left = new BTNode(16);
		root.right.right = new BTNode(25);
		root.right.right.right = new BTNode(27);
		
		System.out.println(findInOrderSuccessor(root, 10) == 11);
		System.out.println(findInOrderSuccessor(root, 12) == 15);
		System.out.println(findInOrderSuccessor(root, 11) == 12);
		System.out.println(findInOrderSuccessor(root, 25) == 27);
		System.out.println(findInOrderSuccessor(root, 27) == Integer.MIN_VALUE);

	}
	/**
	 * If current has right subtree then the inorder successor of current will be the smallest element in the right subtree 
	 * If it does not have a right subtree then
	 * find the nearest ancestor for which the given node is in the left subtree
	 * 
	 * 				15
	 * 				/ \
	 * 			  10   20
	 * 			/ \		/ \
	 * 		   8   12   17 25
	 *       /		/	/	\
	 *       6     11   16   27
	 */
	
	static int findInOrderSuccessor(BTNode root, int data){
		if(root==null)
			return Integer.MIN_VALUE;
		
		BTNode current = findNode(root, data);
		if(current == null)
			return Integer.MIN_VALUE;
		if(current.right !=null){
//			System.out.println(current.right.data + "--");

			return findMinimum(current.right);
		}else{
			// find the nearest ancestor for which the current node is in the left sub tree
			BTNode succesor = null;
			BTNode ancestor = root;
			while(ancestor!=current){
				if(data<ancestor.data){
					succesor = ancestor;
					ancestor = ancestor.left;
				}else{
					ancestor = ancestor.right;
				}
			}
			return succesor == null? Integer.MIN_VALUE:succesor.data;
		}
	}
	
	static BTNode findNode(BTNode root, int data){
		if(root==null || root.data == data)
			return root;
		//BTNode current = root;
		if(data < root.data)
			return findNode(root.left, data);
		else if(data> root.data)
			return findNode(root.right, data);
		return null;
	}
	static int findMinimum(BTNode root){
		if(root==null)
			return Integer.MIN_VALUE;
		BTNode current = root;
		while(current.left!=null)
			current = current.left;
		return current.data;
	}

}

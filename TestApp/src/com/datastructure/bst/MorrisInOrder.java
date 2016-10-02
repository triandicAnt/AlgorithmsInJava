package com.datastructure.bst;

public class MorrisInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = new BTNode(0);
		root.left = new BTNode(2);
		root.right = new BTNode(7);
		root.left.left = new BTNode(3);
		root.left.right = new BTNode(8);
		root.right.left = new BTNode(4);
		root.right.right = new BTNode(3);
		root.left.left.left = new BTNode(5);
		root.right.right.right = new BTNode(8);
		morrisInOrder(root);


	}
	/**
	 * Morris inorder traversal
	 */
	static public void morrisInOrder(BTNode root){
		BTNode current = root;
		while(current!=null){
			if(current.left == null){
				System.out.print(current.data+ " ");
				current = current.right;
			}else{
				BTNode predecessor = current.left;
				while(predecessor.right != current && predecessor.right != null){
					predecessor = predecessor.right;
				}
				if(predecessor.right == null){
					predecessor.right = current;
					current = current.left;
				}else{
					predecessor.right = null;
					System.out.print(current.data+ " ");
					current = current.right;
				}
			}
		}
	}

}

package com.datastructure;

public class BuildTreeWithInPreOrder {
	
	public static void main(String[] args) {
		int [] in = {4 ,2 ,5 ,1 ,6 ,7 ,3 ,8};
		int [] pre = {1 ,2 ,4 ,5  ,3 ,7 ,6 ,8};
		BTNode root = buildTree(pre, in, 0, 7);
		//
		
		inOrder(root);
		
		
	}
	
	static void inOrder(BTNode root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	// Build a tree with given In-order and pre order .
		/**
		 * 
		 * @param preOrder
		 * @param inOrder
		 * @param in_start
		 * @param in_end
		 * @return
		 */
	static int pre_index = 0;

		static BTNode buildTree(int [] preOrder, int [] inOrder, int in_start, int in_end){
			if(in_start>in_end){
				return null;
			}
			BTNode newNode = new BTNode();
			newNode.data = preOrder[pre_index];
			pre_index ++;
			if(in_start == in_end){
				return newNode;
			}
			int in_index = 0;
			in_index= searchNode(inOrder, newNode.data);
			newNode.left = buildTree(preOrder, inOrder, in_start, in_index-1);
			newNode.right = buildTree(preOrder, inOrder, in_index+1, in_end);
			return newNode;
			
			
		}
		/**
		 * 
		 * @param inOrder
		 * @param data
		 * @return
		 */
		static int searchNode(int [] inOrder, int data){
			for (int i = 0; i < inOrder.length; i++) {
				if(inOrder[i]==data)
					return i;
			}
			return -1;
		}
}

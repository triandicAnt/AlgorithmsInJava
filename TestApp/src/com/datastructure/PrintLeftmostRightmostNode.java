package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftmostRightmostNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(9);
		root.right.left.right = new BTNode(8);
		System.out.println();
		printLeftmostRightmost(root);
		System.out.println();
		printExtreme(root);
		
		BTNode root2 = new BTNode(1);
		root2.right = new BTNode(2);
		root2.right.right = new BTNode(3);
		System.out.println();
		printLeftmostRightmost(root2);
		System.out.println();
		printExtreme(root2);
		

	}
	
	static void printLeftmostRightmost(BTNode root){
		if(root == null)
			return;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.offer(root);
		while(!q.isEmpty()){
			int nodeCount = q.size();
			int n = nodeCount;
			while(nodeCount>0){
				BTNode temp = q.poll();
				if(nodeCount == n || nodeCount == 1){
					System.out.print(temp.data + " ");
				}
				nodeCount--;
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
			}
		}
	}
	
	/**
	 * Print extreme nodes
	 */
	static void printExtreme(BTNode root){
		if(root == null)
			return;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.offer(root);
		int level = 0;
		while(!q.isEmpty()){
			int nodeCount = q.size();
			int n = nodeCount;
			
			level ++;
			while(nodeCount>0){
				BTNode temp = q.poll();
				if(level%2!=0 && nodeCount==1){
					System.out.print(temp.data + " ");
					
				}
				else if(nodeCount == n && level%2==0){
					System.out.print(temp.data + " ");
				}
				nodeCount--;
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
			}
		}
	}
}

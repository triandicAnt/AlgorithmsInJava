package com.datastructure.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class DisgonalSumBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.left.left = new BTNode(9);
		root.left.right = new BTNode(6);
		root.left.left.right = new BTNode(10);
		root.left.right.left = new BTNode(11);
		root.right = new BTNode(3);
		root.right.left = new BTNode(4);
		root.right.left.left = new BTNode(12);
		root.right.left.right = new BTNode(7);
		root.right.right = new BTNode(5);
		getDiagonalSum(root);
		
		for(Entry<Integer, Integer> e: map.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static void getDiagonalSum(BTNode root){
		if(root == null)
			return;
		Queue<BTNode> q = new LinkedList<BTNode>();
		root.vd = 0;
		q.offer(root);
		
		while(!q.isEmpty()){
			
			BTNode current = q.poll();
			int vd = current.vd;
			while(current!=null){
				int prevSum = map.get(vd)==null?0:map.get(vd);
				map.put(vd, prevSum + current.data);
				// add left node to queue for further processing
				if(current.left != null){
					current.left.vd = vd+1;
					q.offer(current.left);
				}
				current = current.right;
			}
		}
	}

}

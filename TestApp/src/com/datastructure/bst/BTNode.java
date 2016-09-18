/**
 * 
 */
package com.datastructure.bst;

/**
 * @author Sudhansu
 *
 */
public class BTNode{
	int data;
	BTNode left;
	BTNode right;
	BTNode parent;
	
	BTNode(){
		
	}
	
	BTNode(int n){
		data = n;
		left = right = parent = null;
	}
}
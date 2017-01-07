package com.datastructure.tries;

import java.util.HashMap;

public class TrieClass {
	
//	public static void main(String[] args) {
//		
//		Trie root = null;
//		/**
//		 * acdf
//		 * acfe
//		 * abcd
//		 * 
//		 * create root with a as name
//		 * 
//		 * 
//		 */
//		
//		root = insertString("acdf", root);
//		System.out.println(root.toString());
//		root = insertString("acfe", root);
//		System.out.println(root.toString());
//	}
//	/**
//	 * insert strings in the Trie
//	 * Check the last node's "isEnd" value, it should be true for last node and for all other nodes, it should be true.
//	 * @param str
//	 * @param root
//	 * @return
//	 */
//	static Trie insertString(String str, Trie root){
//		
//		Trie tempRoot = root;
//		// check for null ; if root is null then create root with first character of string
//		// if there is only one character in the string then set the isEnd of the last node as "true"
//		if(tempRoot == null){
//			String rest = str;
//			if(tempRoot == null){
//				// create a root
//				tempRoot = new Trie(String.valueOf(str.charAt(0)));
//				// rest would be the substring from 1 character
//				rest = str.substring(1);
//			}
//			// create next node
//			Trie next = tempRoot;
//			// for each characters in the rest string insert into trie
//			for(char c: rest.toCharArray()){
//				// get the children
//				HashMap<String, Trie> map = next.children;
//				// if children contains the character, set next node
//				if(map.containsKey(String.valueOf(c))){
//					next = map.get(String.valueOf(c));
//				}else{
//					// put the value in the children and then set the next node
//					map.put(String.valueOf(c), new Trie(String.valueOf(c)));
//					next = map.get(String.valueOf(c));
//				}
//			}
//		}
//		// some characters are repeating
//		else{
//			// skip till the common characters and also skip in trie
//			int i = 0;
//			Trie next = tempRoot;
//			Trie current = tempRoot;
//			while(i<str.length() && next!=null){
//				// check if the characters are same
//				if(next.name.equals(String.valueOf(str.charAt(i)))){
//					current = next;
//					i++;
//					HashMap<String, Trie> map = next.children; 
//					next = map.get(String.valueOf(str.charAt(i))); 
//				}else{
//					break;
//				}
//			}
//			// we have found the current node in Trie
//			Trie next1 = current;
//			// do the same thing as for rest characters in the previous case
//			for(char c: str.substring(i).toCharArray()){
//				HashMap<String, Trie> map = next1.children;
//				if(map.containsKey(String.valueOf(c))){
//					next1 = map.get(String.valueOf(c));
//				}else{
//					map.put(String.valueOf(c), new Trie(String.valueOf(c)));
//					next1 = map.get(String.valueOf(c));
//				}
//			}
//		}
//		return tempRoot;
//	}

}

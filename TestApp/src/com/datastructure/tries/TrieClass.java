package com.datastructure.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieClass {
	
	public static void main(String[] args) {
		
		Trie root = null;
		

		/**
		 * acdf
		 * acfe
		 * abcd
		 * 
		 * create root with a as name
		 * 
		 * 
		 */
		
		root = insertString("acdf", root);
		System.out.println(root.toString());
		root = insertString("acfe", root);
		System.out.println(root.toString());
	}
	
	static Trie insertString(String str, Trie root){
		
		Trie tempRoot = root;
		if(tempRoot == null){
			String rest = str;
			if(tempRoot == null)
			{
				tempRoot = new Trie(String.valueOf(str.charAt(0)));
				rest = str.substring(1);
			}
			Trie next = tempRoot;
			int last = 1;
			for(char c: rest.toCharArray()){
				HashMap<String, Trie> map = next.children;
				if(map.containsKey(String.valueOf(c))){
					next = map.get(String.valueOf(c));
				}else{
					map.put(String.valueOf(c), new Trie(String.valueOf(c)));
					next = map.get(String.valueOf(c));
				}
			}
		}
		// some characters are repeating
		else{
			int i = 0;
			Trie next = tempRoot;
			Trie current = tempRoot;
			while(i<str.length() && next!=null){
				System.out.println(next.name + "--" + String.valueOf(str.charAt(i)));
				if(next.name.equals(String.valueOf(str.charAt(i)))){
					current = next;
					i++;
					HashMap<String, Trie> map = next.children; 
					next = map.get(String.valueOf(str.charAt(i))); 
					System.out.println("-----------" + next.name);
				}else{
					break;
				}
			}
			System.out.println(next.name);
		}
		return tempRoot;
	}

}

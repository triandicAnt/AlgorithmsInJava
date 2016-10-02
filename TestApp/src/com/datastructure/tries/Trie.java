package com.datastructure.tries;

import java.util.HashMap;

public class Trie {
	String name;
	HashMap<String , Trie> children;
	boolean isEnd;
	
	public Trie(String name) {
		this.name = name;
		this.children = new HashMap<>();
		this.isEnd = false;
	}
	
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(this.name));
		sb.append("<");
		sb.append(this.children.toString());
		sb.append(">");
		return sb.toString();
	}
}

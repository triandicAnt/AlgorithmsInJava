/**
 * 
 */
package com.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 * @author Sudhansu
 * @param <E>
 * @param <T>
 *
 */
public class AdjacencyList<T,E> {

	/**
	 * @param args
	 */
	HashMap<T, LinkedList<E>> adj = 
			new HashMap<T, LinkedList<E>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyList<Character, Character> a = new AdjacencyList<>();
		a.addToList('s', 'r');
		a.addToList('s', 'w');
		a.addToList('r', 's');
		a.addToList('r', 'v');
		a.addToList('t', 'u');
		a.addToList('t', 'w');
		a.addToList('t', 'x');
		a.addToList('u', 't');
		a.addToList('u', 'y');
		a.addToList('v', 'r');
		a.addToList('w', 's');
		a.addToList('w', 't');
		a.addToList('w', 'x');
		a.addToList('x', 't');
		a.addToList('x', 'w');
		a.addToList('x', 'y');
		a.addToList('y', 'u');
		a.addToList('y', 'x');

		a.printAdjList();

	}
	/**
	 * add elements to the adj list
	 * @param source
	 * @param dest
	 */
	void addToList(T source, E dest){
		if(adj.containsKey(source)){
			LinkedList<E> list = adj.get(source);
			if(dest!=null)
				list.add(dest);
		}
		else{
			LinkedList<E> list = new LinkedList<E>();
			if(dest!=null)
				list.add(dest);
			adj.put(source, list);
		}
	}
	/**
	 * delete elements from the list
	 * @param source
	 * @param dest
	 */
	void deleteFromList(T source, E dest){
		if(adj.containsKey(source)){
			LinkedList<E> list = adj.get(source);
			// not necessarily delete the source when its child are 0
//			if(list.size()==0){
//				adj.remove(source);
//			}
			list.remove(dest);
		}
	}
	
	void printAdjList(){
		if(adj.isEmpty()){
			System.out.println("List is empty!");
			return;
		}
		for (Entry<T, LinkedList<E>> e : this.adj.entrySet()) {
			LinkedList<E> list = e.getValue();
			System.out.print(e.getKey() + ": ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");		
			}
			System.out.println();
		}
	}

}

/**
 * 
 */
package com.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Sudhansu
 *
 */
//@SuppressWarnings("all")

public class GraphTraversals {

	/**
	 * @param <Integer>
	 * @param <Integer>
	 * @param args
	 */
	Map<GraphVertex<Integer,Integer>, LinkedList<GraphVertex<Integer,Integer>>> adj = new HashMap<GraphVertex<Integer,Integer>, LinkedList<GraphVertex<Integer,Integer>>>();

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		//AdjacencyList<Integer,Integer> a = new AdjacencyList<>();
		GraphTraversals g = new GraphTraversals();
		g.createAdjList();
		g.createGraph();

	}
	 void  createAdjList(){
		addToList(createAVertex(1),createAVertex(3));
		addToList(createAVertex(1),createAVertex(5));
		addToList(createAVertex(1),createAVertex(6));
		addToList(createAVertex(1),createAVertex(9));


		addToList(createAVertex(2),createAVertex(3));
		addToList(createAVertex(2),createAVertex(4));
		addToList(createAVertex(2),createAVertex(7));


		addToList(createAVertex(3),createAVertex(1));
		addToList(createAVertex(3),createAVertex(2));
		addToList(createAVertex(3),createAVertex(4));
		addToList(createAVertex(3),createAVertex(7));
		addToList(createAVertex(3),createAVertex(9));

		addToList(createAVertex(4),createAVertex(2));
		addToList(createAVertex(4),createAVertex(3));

		addToList(createAVertex(5),createAVertex(1));
		addToList(createAVertex(5),createAVertex(7));

		addToList(createAVertex(6),createAVertex(1));

		addToList(createAVertex(7),createAVertex(2));
		addToList(createAVertex(7),createAVertex(3));
		addToList(createAVertex(7),createAVertex(5));

		addToList(createAVertex(8),null);


		addToList(createAVertex(9),createAVertex(1));
		addToList(createAVertex(9),createAVertex(3));


	}
//	<Integer,Integer> void createEdge(Integer source, Integer dest, ){
//		GraphVertex<Integer, Integer> source = 
//	}
//	
	 GraphVertex<Integer, Integer> createAVertex(Integer source){
		GraphVertex<Integer,Integer> v = new GraphVertex<>();
		v.name = source;
		v.color = Color.WHITE;
		return v;
	}
	
	 void createGraph(){
		if(adj.isEmpty()){
			System.out.println("List is empty, Graph cannot be created!");
			return;
		}
		for (Entry<GraphVertex<Integer, Integer>, LinkedList<GraphVertex<Integer, Integer>>> e : adj.entrySet()) {
			LinkedList<GraphVertex<Integer, Integer>> list = e.getValue();
			
			System.out.print(e.getKey().toString() + ": ");
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i).toString() + " ");
				}
			}
			System.out.println();
		}
	}
	
	 void dfs(){
			for (Entry<GraphVertex<Integer, Integer>, LinkedList<GraphVertex<Integer, Integer>>> e : adj.entrySet()) {
			if(e.getKey().color==Color.WHITE){
				dfsVisit(e.getKey());
			}
		}
	}
	/**
	 * @param key
	 */
	private void dfsVisit(GraphVertex<Integer, Integer> key) {
		 key.color = Color.GREY;
		 LinkedList<GraphVertex<Integer, Integer>> neighbors =
				 adj.get(key);
//		 for (int i = 0; i < array.length; i++) {
//			
//		}
		 
	}
	void addToList(GraphVertex<Integer, Integer> source, GraphVertex<Integer, Integer> dest){
		if(this.adj.containsKey(source)){
			LinkedList<GraphVertex<Integer, Integer>> list = adj.get(source);
			if(dest!=null)
				list.add(dest);
		}
		else{
			LinkedList<GraphVertex<Integer, Integer>> list = new LinkedList<GraphVertex<Integer,Integer>>();
			if(dest!=null)
				list.add(dest);
			adj.put(source, list);
		}
	}

}

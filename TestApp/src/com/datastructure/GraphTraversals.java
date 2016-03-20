/**
 * 
 */
package com.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

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
	Stack<GraphVertex<Integer, Integer>> s = new Stack<>();

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		//AdjacencyList<Integer,Integer> a = new AdjacencyList<>();
		GraphTraversals g = new GraphTraversals();
		g.createAdjList();
		g.printGraph();
		g.dfs();

	}
	/**
	 * create adjacency list
	 */
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

		addToList(createAVertex(8),createAVertex(10));
		addToList(createAVertex(10), null);


		addToList(createAVertex(9),createAVertex(1));
		addToList(createAVertex(9),createAVertex(3));


	}
/**
 * create a vertex
 * @param source
 * @return
 */
	 GraphVertex<Integer, Integer> createAVertex(Integer source){
		GraphVertex<Integer,Integer> v = new GraphVertex<>();
		v.name = source;
		v.color = Color.WHITE;
		return v;
	}
	/**
	 * print graph
	 */
	 void printGraph(){
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
/**
 * dfs
 */
	 void dfs(){
			// Start dfs from vertex 1
			for (Entry<GraphVertex<Integer, Integer>, LinkedList<GraphVertex<Integer, Integer>>> e : adj.entrySet()) {
			
				if(e.getKey().getColor()==Color.WHITE && e.getKey().isVisited() == false){
					dfsVisit(e.getKey());
					System.out.println();
			}
		}
	}
	
	 
	
/**
 * 
 * @param key
 */
	private void dfsVisit(GraphVertex<Integer, Integer> key) {
//		 key.color = Color.GREY;
//		 key.visited = true;
		 System.out.print(key.getName() + " ");
		 updateColor(key, Color.GREY);
		 updateVisited(key, true);
		 s.push(key);
		 while (!s.isEmpty()) {
			 GraphVertex<Integer, Integer> p = s.peek();
			 GraphVertex<Integer, Integer> unvisited = findUnvisitedVertex(p);
			 if(unvisited==null){
				 GraphVertex<Integer, Integer> tbr = s.peek();
				 updateColor(tbr, Color.BLACK);
				 s.pop();
			 }
			 else{
				 System.out.print(unvisited.getName() + " ");
				 updateColor(unvisited, Color.GREY);
				 updateVisited(unvisited, true);
				 s.push(unvisited);
			 }
		}
	}
	/**
	 * 
	 * @param key
	 * @param color
	 */
	void updateColor(GraphVertex<Integer, Integer> key, Color color){
				
		for (Entry<GraphVertex<Integer, Integer>, LinkedList<GraphVertex<Integer, Integer>>> e : adj.entrySet()) {
			 if(e.getKey().equals(key))
				 e.getKey().setColor(color);
			LinkedList<GraphVertex<Integer, Integer>> list = e.getValue();
			for (GraphVertex<Integer, Integer> graphVertex : list) {
				if(graphVertex.equals(key))
					graphVertex.setColor(color);
			}
		
		}
	}
	/**
	 * 
	 * @param key
	 * @param visited
	 */
	void updateVisited(GraphVertex<Integer, Integer> key, Boolean visited){
		
		for (Entry<GraphVertex<Integer, Integer>, LinkedList<GraphVertex<Integer, Integer>>> e : adj.entrySet()) {
			 if(e.getKey().equals(key))
				 e.getKey().setVisited(visited);
			LinkedList<GraphVertex<Integer, Integer>> list = e.getValue();
			for (GraphVertex<Integer, Integer> graphVertex : list) {
				if(graphVertex.equals(key))
					 	graphVertex.setVisited(visited);
			}
		
		}
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	GraphVertex<Integer,Integer> findUnvisitedVertex(GraphVertex<Integer, Integer > key){
		 LinkedList<GraphVertex<Integer, Integer>> neighbors =
				 adj.get(key);

		 if(neighbors==null)
			 return null;
		 for(GraphVertex<Integer, Integer> n: neighbors)
		 {
			 if(n.isVisited()==false && n.getColor()==Color.WHITE){
				 return n;
			 }
				 
		 }
		 return null;
	}
	/**
	 * 
	 * @param source
	 * @param dest
	 */
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

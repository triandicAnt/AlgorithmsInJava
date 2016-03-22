/**
 * 
 */
package com.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
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
//	for DFS
	Map<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> adj = new HashMap<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>>();
	Stack<GraphVertex<Object,Object>> s = new Stack<>();
	Boolean cycle = false;
	int noOfComponentsInGraph;
	// for BFS
	Queue<GraphVertex<Object, Object>> q = new LinkedList<>();
	LinkedList<GraphVertex<Object, Object>> topologicalSorted = new LinkedList<>();

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		GraphTraversals g = new GraphTraversals();
		g.createAdjList();
		System.out.println("Adjacency List -------------------------------");
		g.printGraph();
		System.out.println("DFS traversal: ");
		g.dfs();
		System.out.println("No. of components: "+ g.noOfComponentsInGraph);
		g.setDefault();
		System.out.println("************************************************");
		g.recursiveDFS();
		System.out.println("Graph has cycle ? " + g.cycle);
		/*GraphTraversals gt = new GraphTraversals();
		gt.addToBfsList();
		System.out.println("Adjacency List -------------------------------");
		gt.printGraph();
		// call bfs
		System.out.println("BFS traversal: ");
		gt.bfs();
		gt.setDefault();*/
		GraphTraversals got = new GraphTraversals();
		got.createAGraph();
		got.printGraph();
		got.recursiveDFS();
		System.out.println("Graph has cycle ? " + got.cycle);
		got.setDefault();

	}
	void createAGraph(){
		addToList(createAVertex('A'),createAVertex('B'));
//		addToList(createAVertex('A'),createAVertex('C'));
		addToList(createAVertex('B'),createAVertex('A'));
//		addToList(createAVertex('B'),createAVertex('C'));
//		addToList(createAVertex('C'),createAVertex('A'));
//		addToList(createAVertex('C'),createAVertex('D'));
//		addToList(createAVertex('D'),createAVertex('C'));

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
	 GraphVertex<Object,Object> createAVertex(Object source){
		GraphVertex<Object,Object> v = new GraphVertex<>();
		v.setName(source);
		v.setColor(Color.WHITE);
		v.setVisited(false);
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
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
			LinkedList<GraphVertex<Object,Object>> list = e.getValue();
			
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
 * dfs method
 * Once a vertex is visited, its color turns grey and when we are done visiting it's all neighbors, its color turns black and we remove it from stack as well.
 */
	 void dfs(){
			// Start dfs from vertex 1
			for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
			
				if(e.getKey().getColor()==Color.WHITE && e.getKey().isVisited() == false){
					dfsVisit(e.getKey());
					System.out.println();
					noOfComponentsInGraph ++;
			}
		}
	}
	
	 
	
/**
 * visit a vertex in dfs and add it to stack
 * @param key
 */
	private void dfsVisit(GraphVertex<Object,Object> key) {
		 System.out.print(key.getName() + " ");
		 updateColor(key, Color.GREY);
		 updateVisited(key, true);
		 s.push(key);
		 while (!s.isEmpty()) {
			 GraphVertex<Object,Object> p = s.peek();
			 GraphVertex<Object,Object> unvisited = findUnvisitedVertex(p);
			 if(unvisited==null){
				 GraphVertex<Object,Object> tbr = s.peek();
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
	 * update the color when a vertex is visited
	 * @param key
	 * @param color
	 */
	void updateColor(GraphVertex<Object,Object> key, Color color){
				
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
			 if(e.getKey().equals(key))
				 e.getKey().setColor(color);
			LinkedList<GraphVertex<Object,Object>> list = e.getValue();
			for (GraphVertex<Object,Object> graphVertex : list) {
				if(graphVertex.equals(key))
					graphVertex.setColor(color);
			}
		
		}
	}
	/**
	 * update the visited flag when the vertex is visited
	 * @param key
	 * @param visited
	 */
	void updateVisited(GraphVertex<Object,Object> key, Boolean visited){
		
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
			 if(e.getKey().equals(key))
				 e.getKey().setVisited(visited);
			LinkedList<GraphVertex<Object,Object>> list = e.getValue();
			for (GraphVertex<Object,Object> graphVertex : list) {
				if(graphVertex.equals(key))
					 	graphVertex.setVisited(visited);
			}
		
		}
	}
	/**
	 * for a vertex find a neighbor that is not visited yet
	 * @param key
	 * @return
	 */
	GraphVertex<Object,Object> findUnvisitedVertex(GraphVertex<Object,Object > key){
		 LinkedList<GraphVertex<Object,Object>> neighbors =
				 adj.get(key);

		 if(neighbors==null)
			 return null;
		 for(GraphVertex<Object,Object> n: neighbors)
		 {
			 if(n.isVisited()==false && n.getColor()==Color.WHITE){
				n.setParent(key);
				 return n;
			 }
//			 else{
//				 if(key.getParent()!=null && !key.getParent().equals(n)){
//					 cycle = true;
//				 }
				 // check whether there is a cycle in the graph
				 // if parent of key is not 'n' then there is a cycle
//			 }
				 
		 }
		 return null;
	}
	/**
	 * add each vertex and its corresponding neighbors to the adj list
	 * @param source
	 * @param dest
	 */
	void addToList(GraphVertex<Object,Object> source, GraphVertex<Object,Object> dest){
		if(this.adj.containsKey(source)){
			LinkedList<GraphVertex<Object,Object>> list = adj.get(source);
			if(dest!=null)
				list.add(dest);
		}
		else{
			LinkedList<GraphVertex<Object,Object>> list = new LinkedList<GraphVertex<Object,Object>>();
			if(dest!=null)
				list.add(dest);
			adj.put(source, list);
		}
	}
	/**
	 * set the color and isVisited to default values
	 */
	void setDefault(){
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
				 e.getKey().setVisited(false);
				 e.getKey().setColor(Color.WHITE);
			LinkedList<GraphVertex<Object,Object>> list = e.getValue();
			for (GraphVertex<Object,Object> graphVertex : list) {
				graphVertex.setVisited(false);
				graphVertex.setColor(Color.WHITE);
			}
		}
	}
	
	void addToBfsList(){
		addToList(createAVertex('r'), createAVertex('s'));
		addToList(createAVertex('r'), createAVertex('v'));

		addToList(createAVertex('s'), createAVertex('r'));
		addToList(createAVertex('s'), createAVertex('w'));
		
		addToList(createAVertex('t'), createAVertex('u'));
		addToList(createAVertex('t'), createAVertex('w'));
		addToList(createAVertex('t'), createAVertex('x'));
		
		addToList(createAVertex('u'), createAVertex('t'));
		addToList(createAVertex('u'), createAVertex('y'));
		
		addToList(createAVertex('v'), createAVertex('r'));
		
		addToList(createAVertex('w'), createAVertex('s'));
		addToList(createAVertex('w'), createAVertex('t'));
		addToList(createAVertex('w'), createAVertex('x'));
		
		addToList(createAVertex('x'), createAVertex('t'));
		addToList(createAVertex('x'), createAVertex('w'));
		addToList(createAVertex('x'), createAVertex('y'));
		
		addToList(createAVertex('y'), createAVertex('u'));
		addToList(createAVertex('y'), createAVertex('x')); 
		
		addToList(createAVertex('z'), createAVertex('a'));
//		addToList(createAVertex('a'), null); 


	}
	/**
	 * bfs algorithm
	 * Visit a vertex, add it to queue. Add all the neighbors of it to the queue and mark them visited and once all neighbors of a vertex are visited, remove that 
	 * vertex from queue.
	 */
	void bfs(){
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
			
			if(e.getKey().getColor()==Color.WHITE && e.getKey().isVisited() == false){
				bfsVisit(e.getKey());
				System.out.println();
				noOfComponentsInGraph ++;
		}
	  }
	}
	
	/**
	 * Once a vertex is visited, its color turns grey and when we are done visiting it's all neighbors, its color turns black and we remove it from queue as well.
	 * @param key
	 */
	void bfsVisit(GraphVertex<Object, Object> key){
		 System.out.print(key.getName() + " ");
		 updateColor(key, Color.GREY);
		 updateVisited(key, true);
		 q.add(key);
		 
		 while (!q.isEmpty()) {
			 GraphVertex<Object,Object> p = q.peek();
			 LinkedList<GraphVertex<Object, Object>> neighbors = adj.get(p);
			 if(neighbors==null){
				 updateColor(p, Color.BLACK);
				 q.poll();			 
			 }
			
			 else{
				 for (GraphVertex<Object, Object> n : neighbors) {
					if(n.isVisited()==false && n.getColor()==Color.WHITE){
						 System.out.print(n.getName() + " ");
						updateColor(n, Color.GREY);
						updateVisited(n, true);
						q.add(n);
					}
				 }
				 updateColor(p, Color.BLACK);
				 q.poll();			 
			}
			
		 }
	}
	
	void recursiveDFS(){
		System.out.println("The DFS of graph is: ");
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : adj.entrySet()) {
			
			if(e.getKey().getColor()==Color.WHITE && e.getKey().isVisited() == false){
				System.out.print(e.getKey().name + " ");
				dfsRecursuveVisit(e.getKey());
				System.out.println();
				noOfComponentsInGraph ++;
			}
		}
	}

	void printTopologicalSorted(){
		System.out.println("Topological Sorted is: ");
		for (GraphVertex<Object, Object> g : topologicalSorted) {
			System.out.print(g.getName() + " ");
		}
	}
	void dfsRecursuveVisit(GraphVertex<Object, Object> key){
		updateColor(key, Color.GREY);
		updateVisited(key, true);
		LinkedList<GraphVertex<Object, Object>> neighbors = this.adj.get(key);
		for(GraphVertex<Object, Object> n : neighbors){
			if(n.getColor()==Color.WHITE && n.isVisited() == false){
				System.out.print(n.name + " ");
				n.setParent(key);
				dfsRecursuveVisit(n);
			}
			else if(key.getParent() != null && !key.getParent().equals(n)){
				//System.out.println("Cycle Detected");
				this.cycle = true;
			}
		}
		updateColor(key, Color.BLACK);
		topologicalSorted.addFirst(key);
	}
}

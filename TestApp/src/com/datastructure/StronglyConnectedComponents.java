/**
 * 
 */
package com.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * @author Sudhansu
 *
 */
public class StronglyConnectedComponents {

	/**
	 * @param args
	 */
	GraphTraversals got;
	/**
	 * 
	 */
	Map<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> revAdj ;//= new HashMap<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>>();
	List<List<GraphVertex<Object, Object>>> sccList;
	public StronglyConnectedComponents() {
		// TODO Auto-generated constructor stub\
		got = new GraphTraversals();
		revAdj = new HashMap<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>>();
		sccList = new LinkedList<>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StronglyConnectedComponents scm = new StronglyConnectedComponents();
		scm.createGraph();
		scm.got.printGraph(scm.got.adj);
		scm.got.recursiveDFS();
		System.out.println();
		System.out.println(Arrays.toString(scm.got.topoS.toArray()));
		scm.reverseAdjacencyList(scm.got.adj);
		System.out.println("Reversed list");
		scm.got.printGraph(scm.revAdj);
		System.out.println("***");
		//System.out.println(Arrays.toString(scm.got.topoS.toArray()));

		//System.out.println("--------------------");
		//scm.createSCCList(scm.revAdj);
		
		/*System.out.println("Reversed list");
		scm.reverseAdjacencyList(scm.got.adj);
		scm.got.printGraph(scm.revAdj);
		*/

	}
	
	void createGraph(){
		got.addToList(got.createAVertex(1),got.createAVertex(2));
		
		got.addToList(got.createAVertex(2),got.createAVertex(3));
		got.addToList(got.createAVertex(3),null);

		got.addToList(got.createAVertex(3),got.createAVertex(1));
		got.addToList(got.createAVertex(3),got.createAVertex(5));

		got.addToList(got.createAVertex(4),got.createAVertex(5));
		
		got.addToList(got.createAVertex(5),got.createAVertex(6));
		
		got.addToList(got.createAVertex(6),got.createAVertex(4));

		got.addToList(got.createAVertex(7),got.createAVertex(6));
	}

	void reverseAdjacencyList(Map<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> map){
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : map.entrySet()) {
			GraphVertex<Object, Object> key = e.getKey(); // old key
			LinkedList<GraphVertex<Object, Object>> values = e.getValue(); // old values
			
			for(GraphVertex<Object, Object> n : values){ // iterate over values
				
				GraphVertex<Object, Object> newKey = findVertexForKey(this.revAdj, n);
//				if(newKey == null)
				//
				LinkedList<GraphVertex<Object, Object>> neigh = map.get(newKey);
//				if((int)newKey.getName()==5)
//					System.out.println(neigh.toString());

				if(neigh==null){
					neigh = new LinkedList<>();
				}
				neigh.add(new GraphVertex<>(key));
				if(newKey==null)
					this.revAdj.put(new GraphVertex<>(n), neigh);		
				else
					this.revAdj.put(newKey, neigh);
			}		
		}
		for(GraphVertex<Object, Object> o : map.keySet()){
			if(findVertexForKey(this.revAdj,o.getName())==null){
				this.revAdj.put(new GraphVertex<>(o), null);
			}
		}
	}
	
	GraphVertex<Object, Object> findVertexForKey(Map<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> map, Object value){
		for(GraphVertex<Object, Object> key : map.keySet()){
			if(key.getName()== value)
				return key;
		}
		return null;
	}
	void setDefault(Map<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> map){
		System.out.println("====="+map.toString());
		for (Entry<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> e : map.entrySet()) {
				 e.getKey().setVisited(false);
				 e.getKey().setColor(Color.WHITE);
			LinkedList<GraphVertex<Object,Object>> list = e.getValue();
			for (GraphVertex<Object,Object> graphVertex : list) {
				graphVertex.setVisited(false);
				graphVertex.setColor(Color.WHITE);
			}
		}
	}
	void createSCCList(Map<GraphVertex<Object,Object>, LinkedList<GraphVertex<Object,Object>>> map){
		System.out.println("*** "+ this.got.topoS.peek());
		setDefault(this.revAdj);
		System.out.println(this.revAdj.toString());

		Object key = this.got.topoS.peek();
		GraphVertex<Object, Object> vertex = findVertexForKey(map, key);
		System.out.println("Here" + vertex.getColor() + vertex.isVisited());

		while(!this.got.topoS.isEmpty()){
			System.out.println("Here" + vertex.getColor() + vertex.isVisited());
			
			if(vertex.getColor()==Color.WHITE && vertex.isVisited() == false){
				LinkedList<GraphVertex<Object, Object>> sList = new LinkedList<>();
				sList.add(vertex);
				this.got.topoS.pop();
				dfsRecursuveVisit(vertex, sList);
				System.out.println("---"+ sList.toString());
				this.sccList.add(sList);
			}
		}
	}

	void dfsRecursuveVisit(GraphVertex<Object, Object> key, LinkedList<GraphVertex<Object, Object>> sList){
		
		System.out.println("Here");
		this.got.updateColor(this.revAdj,key, Color.GREY);
		this.got.updateVisited(this.revAdj,key, true);
		LinkedList<GraphVertex<Object, Object>> neighbors = this.revAdj.get(key);
		System.out.println("%%%"+neighbors.toString());
//		for(GraphVertex<Object, Object> n : neighbors){
//			if(n.getColor()==Color.WHITE && n.isVisited() == false){
//				sList.add(n);
//				this.got.topoS.pop();
//				dfsRecursuveVisit(n, sList);
//			}
//			
//		}
		this.got.updateColor(this.revAdj,key, Color.BLACK);
	}
	
	void printSCCOmponents()
	{
		
	}
}

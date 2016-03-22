/**
 * 
 */
package com.datastructure;

/**
 * @author Sudhansu
 *
 */
public class TopologicalSort {

	/**
	 * @param args
	 */
	GraphTraversals got = new GraphTraversals();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSort ts = new TopologicalSort();
		ts.createGraph();
		ts.got.printGraph();
		ts.got.recursiveDFS();
		ts.got.printTopologicalSorted();

	}
	void createGraph(){
		got.addToList(got.createAVertex(1),got.createAVertex(2));
		got.addToList(got.createAVertex(1),got.createAVertex(4));
		got.addToList(got.createAVertex(1),got.createAVertex(5));

		got.addToList(got.createAVertex(2),got.createAVertex(3));

		got.addToList(got.createAVertex(3),null);

		got.addToList(got.createAVertex(4),null);
		
		got.addToList(got.createAVertex(5),got.createAVertex(2));
		got.addToList(got.createAVertex(5),got.createAVertex(3));
		got.addToList(got.createAVertex(5),got.createAVertex(4));
		
		got.addToList(got.createAVertex(6),got.createAVertex(3));
		got.addToList(got.createAVertex(6),got.createAVertex(5));
		
	}

}

/**
 * 
 */
package com.graph;
import java.util.List;

import com.graph.GraphVertex;
/**
 * @author Sudhansu
 *
 */
public class Graph<T,E> {
	private List<Edge<T,E>> allEdges;
//	private 
}
class Edge<T,E>{
	private boolean isDirected = false;
	/**
	 * @return the isDirected
	 */
	public boolean isDirected() {
		return isDirected;
	}

	/**
	 * @param isDirected the isDirected to set
	 */
	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	/**
	 * @return the v1
	 */
	public GraphVertex<T, E> getV1() {
		return v1;
	}

	/**
	 * @param v1 the v1 to set
	 */
	public void setV1(GraphVertex<T, E> v1) {
		this.v1 = v1;
	}

	/**
	 * @return the v2
	 */
	public GraphVertex<T, E> getV2() {
		return v2;
	}

	/**
	 * @param v2 the v2 to set
	 */
	public void setV2(GraphVertex<T, E> v2) {
		this.v2 = v2;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	private GraphVertex<T, E> v1;
	private GraphVertex<T, E> v2;
	int weight;
	
	Edge(GraphVertex<T,E> v1, GraphVertex<T,E> v2, boolean isDirected, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.isDirected = isDirected;
		this.weight = weight;
	}
}
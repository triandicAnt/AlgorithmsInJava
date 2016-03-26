/**
 * 
 */
package com.graph;

/**
 * @author Sudhansu
 *
 */
enum Color {
    WHITE, GREY, BLACK 
}
public class GraphVertex<T,E> {
	T name;
	boolean visited;
	Color color;
	GraphVertex<T, E> parent;
	public GraphVertex()
	{
		this.setColor(Color.WHITE);
		this.setVisited(false);
	}
	 public GraphVertex(T name) {
		    this.name = name; 
		    this.setColor(Color.WHITE);
			this.setVisited(false);
		  }
	

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    @SuppressWarnings("unchecked")
	GraphVertex<T, E> g = (GraphVertex<T, E>)obj;
    if(g.name instanceof String){
    	return this.name.equals(g.name);
    }
    else{
    	return (this.name==g.name);
    }
}

	@Override
	public int hashCode() {
			return this.name.hashCode();
		}

	@Override
	public String toString() {
		if(this.name==null)
			return "";
		else
			return this.name.toString();
	}

	/**
	 * @return the name
	 */
	public T getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(T name) {
		this.name = name;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the parent
	 */
	public GraphVertex<T, E> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(GraphVertex<T, E> parent) {
		this.parent = parent;
	}
}

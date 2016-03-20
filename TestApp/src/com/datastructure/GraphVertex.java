/**
 * 
 */
package com.datastructure;

import java.util.ArrayList;

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
}

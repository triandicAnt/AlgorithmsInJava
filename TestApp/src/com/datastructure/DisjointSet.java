/**
 * 
 */
package com.datastructure;

import java.util.HashMap;

/**
 * @author Sudhansu
 *
 */
/**
 * make_set
 * union_set
 * find_set
 */
public class DisjointSet {

	/**
	 * @param args
	 */
	HashMap<Integer, DNode> map = new HashMap<Integer, DNode>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DisjointSet d = new DisjointSet();
		d.makeSet(1);
		d.makeSet(2);
		d.makeSet(3);
		d.makeSet(4);
		d.makeSet(5);
		d.makeSet(6);
		d.makeSet(7);
		d.makeSet(8);

		d.unionSet(1, 2);
		d.unionSet(2, 3);
		d.unionSet(4, 5);
		d.unionSet(6, 7);
		d.unionSet(5, 6);
		d.unionSet(3, 7);
		d.unionSet(7, 8);
		for (int i = 1; i <= 8; i++) {
			System.out.println(d.findSetData(i));
		}
		System.out.println(d.findSetData(11));


	}
	/**
	 * make_set
	 * @param data
	 */
	void makeSet(int data){
		DNode d = new DNode();
		d.data = data;
		d.parent = d;
		d.rank = 0;
		map.put(data, d);
	}
	/**
	 * find_set
	 * @param data
	 * @return
	 */
	DNode findSet(int data){
		DNode n = map.get(data);
		if(n==null){
			System.out.println("Node not found!");
			return null;
		}
		if(n.parent == n)
			return n;
		n.parent = findSet(n.parent.data);
		return n.parent;
	}
	/**
	 * find_set_data
	 * @param data
	 * @return
	 */
	int findSetData(int data){
		DNode d = findSet(data);
		if(d==null)
			return Integer.MIN_VALUE;
		else
			return d.data;
	}
	/**
	 * union_set 
	 * @param n1
	 * @param n2
	 */
	void unionSet(int n1, int n2){
		DNode parent1 = findSet(n1);
		DNode parent2 = findSet(n2);
		if(parent1==null || parent2 == null)
		{
			System.out.println("Parent not found!!");
			return;
		}
		// if both parent are same do nothing
		if(parent1.data==parent2.data)
			return;
		// else make the parent with higher rank as parent
		if(parent1.rank>=parent2.rank){
			parent2.parent = parent1;
			// increment the rank if both ranks are same
			if(parent1.rank == parent2.rank)
				parent1.rank = parent1.rank +1;
		}else{
			parent1.parent = parent2;
		}
	}
}
class DNode{
	int data;
	DNode parent;
	int rank;
}


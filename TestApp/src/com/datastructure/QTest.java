package com.datastructure;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class QTest {

 public static void main (String[] args) {
  Queue<String> que = new LinkedList<>();
  que.add("first");
  que.offer("second");
  que.offer("third");
  que.add("forth");
 // System.out.println("Queue Print:: " + que);

  String head = que.element();
  //System.out.println("Head element:: " + head);
//
  String element1 = que.poll();
  //System.out.println("Removed Element:: " + element1);
//
  //System.out.println("Queue Print after poll:: " + que);
  String element2 = que.remove();
  //System.out.println("Removed Element:: " + element2);

  //System.out.println("Queue Print after remove:: " + que);  
  
  Map<String, Integer> map = new HashMap<String, Integer>();
  map.put("A", 34);
  map.put("B", 25);
  map.put("C", 50);
  map.put("D", 50); // "duplicate" value

  int [] a = new int [] {};
  
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
	  @Override
	// Max Heap
	  /*public int compare(Integer i, Integer j){
		  if(i>j)
			  return -1;
		  if(i<j)
			  return 1;
		  else 
			  return 0;
	  } */
	// Min Heap
	  public int compare(Integer i, Integer j){
		  if(i>j)
			  return 1;
		  if(i<j)
			  return -1;
		  else 
			  return 0;
	  }
  });
  pq.offer(2);
  pq.offer(1);
  pq.offer(3);
  pq.offer(4);
  System.out.println(pq);
 }
  
}

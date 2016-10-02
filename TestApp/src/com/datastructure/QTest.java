package com.datastructure;
import java.math.BigInteger;
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
  pq.poll();
  System.out.println(pq);
  
  int x = 3;
  int i = 1;
  for( i =1 ; i*(i+1)/2<=x; i++){
	  if(i*(i+1) > 2*x){
		  break;
	  }
  }
//  System.out.println(i-1); 
  
  System.out.println('a'>'b');
  
 // long[] l = {2,5,8,3};
  
//  BigInteger bd = new BigInteger("922337203685477582012312321");
//  System.out.println(bd.multiply(new BigInteger("15")));
//  System.out.println(bd); 
  
  long l = 2;
  
  
  long low = 0;
  long high = l;
  
  while(low<=high){
	  long mid =(long) Math.ceil((low+high)/2);
	  if(mid*(mid+1)/2 == l)
		  System.out.println(mid);
	  else if(mid*(mid+1)/2<l){
		  low = mid;
	  }else{
		  high = mid;
	  }

  }
  
 }

 
 
}






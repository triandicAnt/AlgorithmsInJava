package com.datastructure;
import java.util.LinkedList;
import java.util.Queue;

public class QTest {

 public static void main (String[] args) {
  Queue<String> que = new LinkedList<>();
  que.add("first");
  que.offer("second");
  que.offer("third");
  que.add("forth");
  System.out.println("Queue Print:: " + que);

  String head = que.element();
  System.out.println("Head element:: " + head);
//
  String element1 = que.poll();
  System.out.println("Removed Element:: " + element1);
//
  System.out.println("Queue Print after poll:: " + que);
  String element2 = que.remove();
  System.out.println("Removed Element:: " + element2);

  System.out.println("Queue Print after remove:: " + que);  
 }
}

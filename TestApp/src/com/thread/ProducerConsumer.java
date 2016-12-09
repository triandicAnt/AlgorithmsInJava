/**
 * 
 */
package com.thread;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Sudhansu
 * 
 * Producer and consumer problem using wait and notify
 */

public class ProducerConsumer {

	// create a lock object that the synchronize blocks will acquire lock
	private static Object lock = new Object();
	
	// create the limit of the producer
	private static final int limit  = 10;
	
	// create a queue that will hold the values produced by the producer
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	
	// create a producer method
	public static void producer(){
		// create a value that will be inserted into the queue 
		int value = 0;
		
		while(true){
			
			// add in the synchronized block
			synchronized (lock) {
				
				// wait if the queue is full
				while(queue.size() == limit){
					
					// wait 
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				// insert the value in the queue and the notify
				// increment the value as well
				queue.add(value++);
				
				// notify the consumer 
				lock.notify();
			}
			
		}
		
	}
	
	// create a consumer method
	public static void consumer() throws InterruptedException{
		
		// create a random object
		Random r = new Random();
		
		while(true){
			
			// consume in synchronize block
			synchronized (lock) {
				// if the queue is empty then wait for producer to insert values to it
				while(queue.size()==0){
					
					// wait till the producer produces some values to it
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				// consume values and print it
				int value = queue.removeFirst();
				
				// print it along with the queue count
				System.out.println("the value is "+value + " the size is "+queue.size());
				
				// notify the producer
				lock.notify();
				
				// sleep for some time
				Thread.sleep(r.nextInt(1000));

			}
		}
				
	}
	public static void main(String[] args) {
		
		// create a thread for producer
		
		Thread t1 = new Thread(new Runnable(){
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				producer();
			}
		});
		
		// create a thread for consumer
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		// start both the threads
		t1.start();
		t2.start();
		
		// join and wait to complete
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

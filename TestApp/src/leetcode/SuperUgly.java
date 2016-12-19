/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;

/**
 * @author Sudhansu
 *
 */
public class SuperUgly {

	 public int nthSuperUglyNumber(int n, int[] primes) {
	        int ugly[] = new int [n];
	        
	        // add all primes to PQ
	        PriorityQueue<Num> pq = new PriorityQueue<Num>();
	        for(int a:primes){
	            pq.add(new Num(a,1,a));
	        }
	        ugly[0]=1;
	        for(int i=1;i<n;i++){
	            ugly[i] = pq.peek().v;
	            //remove duplicate entries
	            while(ugly[i]==pq.peek().v){
	                Num num = pq.poll();
	                pq.add(new Num(num.pv*ugly[num.i],num.i+1,num.pv));
	            }
	        }
	        return ugly[n-1];
	    }
	}
	class Num implements Comparable<Num>{
	    int v;
	    int i;
	    int pv;
	    Num(int v, int i, int pv){
	        this.v=v;
	        this.i=i;
	        this.pv=pv;
	    }
	    public int compareTo(Num next){
	        return this.v-next.v;
	    }
	}
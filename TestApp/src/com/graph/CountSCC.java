package com.graph;

public class CountSCC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strongRelation(5, 7));
		
	}
	
	/**
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	static long strongRelation(int n, int m) {
	       int low = 1; 
	       int high = n + 1; 
	       int mid = (high + low)/2;
	       while (high > low + 1){
	            if (helper(mid, n) < m){
	                low = mid; 
	                mid = (high + low)/2;
	            }else{
	                high = mid; 
	                mid = (high + low)/2;
	       }
	      }
	      return high;

	    }
	static int helper(int r, int n){
	    int a = n%r;
	    int b = r - a;
	    int x = n/r + 1;
	    int y = n/r;
	    int ret = a*x*b*y +
	        a*(a-1)*x*x/2 +
	        b*(b-1)*y*y/2;
	    return ret;
	}

}

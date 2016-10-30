/**
 * 
 */
package com.datastructure.bst;

/**
 * @author Sudhansu
 *
 */
public class NumberOfBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(fact(22));
		System.out.println(countTree(4));

	}
	 public static int numTrees(int n) {

				// (2n)!/(n+1)!n!
				long x = fact(2*n);
				long y = fact(n+1);
				long z = fact(n);
				System.out.println(x + " " + y + " " + z);
				return (int)(x/(y*z));
	    }
	    
	    public static long fact(int n){
	        if(n<=1)
	            return 1;
	        long fact[] = new long [n+1];
	        fact[0] = 1;
	        fact [1] = 1;
	        for(int i=2;i<=n;i++){
	            fact[i] = i*fact[i-1];
	        }
	        return fact[n];
	    }
	    
	    public static int countTree(int n){
	    	if(n<=1)
	    		return 1;
	    	int arr [] = new int [n+1];
	    	arr[0] = 1;
	    	arr[1] = 1;
	    	//int i = n-1;
	    	int j = 0;
	    	int k = 0;
	    	for(int i = 2; i<=n;i++){
	    		j = 0;
	    		k = i-1;
		    	int sum = 0;

		    	while(k>=0 &&j<=i-1){
		    		sum += arr[k]*arr[j];
		    		k--;
		    		j++;
		    	}
		    	arr[i] = sum;
	    	}
	    	return arr[n];
	    }

}

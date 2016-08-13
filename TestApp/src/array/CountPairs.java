package array;

public class CountPairs {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		int []a = {3,3,3,3};
		int []b = {4,4,2,2};
		int [] c = {1,4,4,2,2,3,3};
    	int [] d = {1,3,2,2,3};
    int []e =  {1,4,4,2,1,3,3};
    int [] f = {4,4,1};
   System.out.println(printPairsCount(a, 6) == countPair(a, 6));
   System.out.println(printPairsCount(b, 6) == countPair(b, 6));

   System.out.println(printPairsCount(c, 6) == countPair(c, 6));

   System.out.println(printPairsCount(d, 5) == countPair(d, 5));
   System.out.println(printPairsCount(e, 6) == countPair(e, 6));
   System.out.println(printPairsCount(f, 5) == countPair(f, 5));

		
	}
	
	  static int countPair(int a[], int x){    
	     	int count = 0;
	      for (int i = 0; i<a.length; i++){
	        for (int j =i+1; j<a.length; j++){
	          if(a[i]+a[j] == x){
	            count ++;
	          }
	       }
	      }
	      return count;
	    }
	  
	
	public static int printPairsCount(int a[], int x) {
	    int count = 0;
	    // create an array of size as x
	    int[] temp = new int[x];
	    /**
	     * Iterate through each element of the array and check whether the difference 
	     * x-a[i] is greater than 0 or not. If it is greater than 0 then add the value
	     * at index diff in the temp array to the count.
	     * Also increment the repetition index in the temp array based on the original 
	     * array elements.
	     */
	    for (int i = 0; i < a.length; ++i) {
	        int diff = x - a[i];
	        if (diff >= 0) {
	            count += temp[diff];
	        }
	        temp[a[i]] += 1;
	    }
	    return count;
	}

}

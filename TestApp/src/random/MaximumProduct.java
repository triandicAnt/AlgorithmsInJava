/**
 * 
 */
package random;

/**
 * @author Sudhansu
 *
 */
public class MaximumProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int []{2,3,10,11,5,3};
		printMaxProductPair(a);
		maxDifference(a);
		int [] b = new int []{3,2,-2,1,-4,4};
		findLCS(b);

	}
	/**
	 * Find two elements in the array such that the index of largest element is greater than the second largest element and their product is max.
	 */
	/**
	 * 
	 * @param a
	 */
	static void printMaxProductPair(int []a){
		int max = -1;
		int si=0;
		int li=0;
		int l = a[a.length-1];
		for (int i = a.length-2; i >=0; i--) {
			if(a[i]<l){
				if(a[i]*l>max)
				{
					max = a[i]*l;
					si = i;
				}
				
			}
			else{
				l=a[i];
				li = i;
				
			}
		}

		System.out.println("the pairs are "+max + " " +a[si] + " " + a[li]);
	}
	
	/**
	 * Find maximum difference between two elements such that second element has higher index than the first element.
	 */
	/**
	 * 
	 * @param a
	 */
	static void maxDifference(int []a){
		if(a.length<2)
			return;
		int min = a[0];
		int max_diff = a[1]-a[0];
		for (int i = 1; i < a.length; i++) {
//			if(a[i]-min>max_diff){
//				max_diff = a[i]-min;
//			}
			max_diff = Math.max(a[i]-min,max_diff);
			
			if(a[i]<min){
				min = a[i];
			}
		}
		System.out.println("Maximum difference is "+ max_diff);
	}

	/**
	 * Largest contiguous sum in an array.
	 */
	static void findLCS(int [] a){
		if(a.length<2)
			return;
		int sum_so_far = 0;
		int max_sum = 0;
		for (int i = 0; i < a.length; i++) {
			/*sum_so_far = a[i] + sum_so_far;
			if(sum_so_far<0)
				sum_so_far = 0;
			else if(sum_so_far>max_sum)
				max_sum = sum_so_far;
			*/	
			sum_so_far = Math.max(a[i], a[i]+sum_so_far);
			max_sum = Math.max(sum_so_far, max_sum);
		}
		System.out.println("LCS is "+ max_sum);
	}
}

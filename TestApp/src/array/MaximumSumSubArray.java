package array;

public class MaximumSumSubArray {
	
	public static void main(String[] args) {
		int []b = {-2,-3,-4,-1};
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maximumSumSubArray(a));
		System.out.println(maximumSumSubArray(b));
		System.out.println("---------------");
		int [] c = { 15, 27, 14, 38, 26, 55, 46, 65, 85 } ;
		System.out.println(LIS(c));
		int []d = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(LIS(d));

	}
	
	/**
	 * Kadane's algorithm
	 */
	
	public static int maximumSumSubArray(int [] a){
		int sf =0 ;
		int ms = 0;
		for(int i = 0; i<a.length; i++){
			sf = sf+a[i];
			if(sf<0){
				sf= 0;
			}
			else if (sf>ms){
				ms = sf;
			}
		}
		return ms;
	}
	
	// LIS
	public static int LIS(int []a){
		int [] b = new int [a.length];
		for(int i=0; i<b.length;i++){
			b[i] =1;
		}
		for(int i = 1; i<a.length;i++){
			for(int j = 0;j<i;j++){
				if(a[i]>a[j]){
					b[i] = Math.max(b[i], b[j]+1);
				}
			}
		}
		int max = 0;
		for(int i:b){
			if(i>max)
				max = i;
		}
		return max;
	}
	
}

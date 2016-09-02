/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class FindPairWithleastDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] a = new int []{4,1,6,9,12,2,5};
		int [] a = new int[]{6,9,23,45,-2,-4,3,2,11};
		FindPairWithleastDiff f = new FindPairWithleastDiff();
		f.findPairWithSmallestDiff(a);
	}
	/**
	 * find a pair with minimum absolute difference
	 * @param a
	 */
	void findPairWithSmallestDiff(int []a){
		Arrays.sort(a);
		int x=a[0], y =a[1];
		int min = Math.abs(a[1]-a[0]);
		for (int i = 1; i < a.length; i++) {
			int temp = Math.abs( a[i]-a[i-1]);
			if(temp<min){
				min = temp;
				x=a[i];
				y=a[i-1];
			}
		}
		System.out.println(x+ "," + y);
	}
}

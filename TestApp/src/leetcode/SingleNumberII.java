/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class SingleNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(number(new int[]{3,3,3,2}));

	}
	public static int number(int [] nums){
		int one =0;
		int two = 0;
		for(int a:nums){
			one = (one ^ a)& ~two;
			two = (two ^ a)& ~one;
			System.out.println(one +  " " + two);
		}
		return one;
	}
}

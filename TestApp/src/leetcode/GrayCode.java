/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(2));

	}
	
	public static List<Integer> grayCode(int n){
		int max = (int) (Math.pow(2,n) -1);
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<=max;i++){
			list.add(Integer.parseInt(Integer.toBinaryString((i >> 1) ^ i), 2));
		}
		return list;
		
	}

}

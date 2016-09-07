/**
 * 
 */
package string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class AllPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println(Arrays.toString(allPermutation(s).toArray()));

	}
	
	static ArrayList<String> allPermutation(String str){
		if(str == null)
			return null;
		ArrayList<String> allPerm = new ArrayList<>();
		if(str.length() == 0)
			{
				allPerm.add("");
				return allPerm;
			}
		char c = str.charAt(0);
		String rem = str.substring(1);
		ArrayList<String> subPerm = allPermutation(rem);
		
		for(String s :subPerm){
			for (int i = 0; i <= s.length(); i++) {
				String s1 = getCombined(s, c,i);
				allPerm.add(s1);
			}
		}
		return allPerm;
	}
	
	static String getCombined(String str, char c, int index){
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, index));
		sb.append(c);
		sb.append(str.substring(index, str.length()));
		return sb.toString();
	}

}

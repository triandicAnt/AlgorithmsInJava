/**
 * 
 */
package random;

import java.util.TreeMap;

/**
 * @author Sudhansu
 *
 */
/*Find String intersection
 * 
 */
public class StringIntersect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcde";
		String s2 = "abdf";
		System.out.println(intersect(s1, s2));
		/*
		 * a-1
		 * b-1
		 * c-1
		 * d-1
		 * e-1
		 */

	}

	public static String intersect(String s1, String s2){
		if(s1==null || s2 == null)
			return null;
		TreeMap<Character, Integer> t = new TreeMap<>();
		for(char c: s1.toCharArray()){
			if(t.containsKey(c)){
				int i = t.get(c);
				t.put(c, i+1);
			}
			else{
				t.put(c, 1);
			}
		}
		StringBuffer s = new StringBuffer();
		for(char c : s2.toCharArray()){
			if(t.containsKey(c)&& t.get(c)>0){
				s.append(c);
				int i = t.get(c);
				t.put(c, i-1);
			}			
		}
		
		return s.toString();
	}
}

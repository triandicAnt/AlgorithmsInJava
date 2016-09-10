package string;

import java.util.HashMap;

public class MatchPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "acc";
		System.out.println(encodeString(p));
		String [] strArr = new String [] {"xyz","abb", "sdsds", "tdd", "ccd"};
		matchPattern(strArr, p);

	}
	
	static void matchPattern(String[] strArr, String pattern){
		String p = encodeString(pattern);
		for(String s: strArr){
			if(encodeString(s).equals(p)){
				System.out.println(s);
			}
		}
	}
	
	static String encodeString(String pattern){
		StringBuffer sb = new StringBuffer();
		int v = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c: pattern.toCharArray()){
			if(!map.containsKey(c)){
				map.put(c, v++);
			}
			sb.append(map.get(c));
		}
		return sb.toString();
	}

}

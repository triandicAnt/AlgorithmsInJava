package string;

import java.util.ArrayList;
import java.util.List;

// ref : http://stackoverflow.com/questions/6804956/interleaving-of-two-strings
public class StringInterleaving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Input: str1 = "AB",  str2 = "CD"
			Output:
			    ABCD
			    ACBD
			    ACDB
			    CABD
			    CADB
			    CDAB
			
			Input: str1 = "AB",  str2 = "C"
			Output:
			    ABC
			    ACB
			    CAB
		 */
				
		System.out.println(stringInterleaving("AB", "CD").toString());
		System.out.println(stringInterleaving("AB", "C"));

	}
	
	static List<String> stringInterleaving(String s, String t){
		List<String> result = new ArrayList<String>();
		// if s is null add t
		if(s.isEmpty())
			result.add(t);
		// if t is null add s
		else if(t.isEmpty())
			result.add(s);
		else{
			// iterate over any string 
			for(int i = 0; i<=s.length();i++){
				char c = t.charAt(0);
				String left = s.substring(0, i);
				String right = s.substring(i);
				List<String> resTemp = stringInterleaving(right, t.substring((1)));
				for(String str: resTemp){
					result.add(left+c+str);
				}
			}
		}
		return result;
	}
}

package string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
// our main class becomes a file but the main method is still found
//http://stackoverflow.com/questions/9734474/find-longest-substring-without-repeating-characters
public class LongestNonRepeatingSubstring
{
 	public static void main(String[] args) {
	    findLongestSub("stackoverflow");
//	    System.out.println("abc".indexOf('d'));
//	    System.out.println("stackoverflow".substring("stackoverflow".lastIndexOf('o')));
	    System.out.println(findLengthOfLongest("stackoverflow"));
	    System.out.println(findLengthOfLongest("dvdf"));
	}
	
	public static void findLongestSub(String str){
	    HashSet<Character> hs = new HashSet<Character>();
	    char[] charArray = str.toCharArray();
	    String l = "";
	    String o = "";
	    for(char c: charArray){
	    	
	        if(hs.contains(c)){
		        int first = l.indexOf(c);
		        l = l.substring(first);

	            //l = "";
	            hs.clear();
	        }
	        l += c;
	        if(l.length()>o.length()){
	            o = l;
	        }
	        hs.add(new Character(c));
	    }
	    System.out.println(o);
	 

	}
	
	public static int findLengthOfLongest(String s){
		HashSet<Character> set = new HashSet<Character>();
		int count=0, i=0 ,j=0;
		int n = s.length();
		while(i<n && j<n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				count = Math.max(count, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return count;
	}
	
}

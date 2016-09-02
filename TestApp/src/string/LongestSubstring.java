package string;
import java.lang.Math; // header stuff MUST go above the first class
import java.util.*;
import java.util.Arrays;
// our main class becomes a file but the main method is still found
//http://stackoverflow.com/questions/9734474/find-longest-substring-without-repeating-characters
public class LongestSubstring
{
 	public static void main(String[] args) {
	    findLongestSub("ABDEFGABEF");
	}
	
	public static void findLongestSub(String str){
	    HashSet<Character> hs = new HashSet<Character>();
	    char[] charArray = str.toCharArray();
	    String l = "";
	    String o = "";
	    for(char c: charArray){
	        if(hs.contains(c)){
	            l = "";
	            hs.clear();
	        }
	        l += c;
	        if(l.length()>o.length()){
	            o = l;
	        }
	        hs.add(new Character(c));
	    }
	    System.out.println(o.length());
	}
}
// this will become its own file too (and these can be in any order)

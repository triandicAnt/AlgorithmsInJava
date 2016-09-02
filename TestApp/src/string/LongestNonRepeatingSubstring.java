package string;
import java.util.HashSet;
// our main class becomes a file but the main method is still found
//http://stackoverflow.com/questions/9734474/find-longest-substring-without-repeating-characters
public class LongestNonRepeatingSubstring
{
 	public static void main(String[] args) {
	    findLongestSub("stackoverflow");
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
	    System.out.println(o);
	}
}
// this will become its own file too (and these can be in any order)

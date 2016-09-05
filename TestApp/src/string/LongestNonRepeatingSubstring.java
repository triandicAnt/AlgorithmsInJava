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
	    ArrayList<String[]> arr = new ArrayList<>();
	    arr.add(new String [] {"a","dd","sddf"});
	    arr.add(new String [] {"c","bd","bddf"});
	    arr.add(new String [] {"b","cd","addf"});
	    
	    Collections.sort(arr,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[1].compareTo(otherStrings[1]);
            }
        });
	    for (String[] sa : arr) {
            System.out.println(Arrays.toString(sa));
        }

	}
	
}
// this will become its own file too (and these can be in any order)

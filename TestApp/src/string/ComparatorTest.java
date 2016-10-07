package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

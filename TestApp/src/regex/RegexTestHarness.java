/** Taken from oracle java tutorials
 * 
 */
package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sudhansu
 *
 */
public class RegexTestHarness {
	 public static void main(String[] args){
	        Scanner in = new Scanner(System.in);
	        while (true) {
	        	System.out.println("Enter your regex:");
	            Pattern pattern = 
	            Pattern.compile(in.nextLine(), Pattern.CASE_INSENSITIVE);
	            System.out.println("Enter input string to search: ");
	            Matcher matcher = 
	            pattern.matcher(in.nextLine());
	            /**
	             * System.out.println( matcher.group() );
	                System.out.println(matcher.start());
	                System.out.println(matcher.end());
	             */
	            boolean found = false;
	            while (matcher.find()) {
	                System.out.println("I found the text " + matcher.group() +
	                    " starting at " +matcher.start() +
	                    " index and ending at index " + matcher.end()
	                    );
	                found = true;
	            }
	            if(!found){
	                System.out.println("No match found.");
	                continue;
	    	       // in.close();

	            }
	        }
	 }
}

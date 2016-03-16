/**
 * 
 */
package regex;

import java.util.regex.Pattern;

/**
 * @author Sudhansu
 *
 */
public class StringSplit {

	private static final String REGEX = " ";
	private static final String input = "one two three four";
	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		String [] items = p.split(input);
		for (String string : items) {
			System.out.println(string);
		}
		System.out.println("----");
		splitStrings();
	}
	 static void splitStrings(){
		String regex = "\\d";
		String input = "one1two2three3four4five5";
		Pattern p = Pattern.compile(regex);
		String [] items = p.split(input);
		for (String string : items) {
			System.out.println(string);
		}
	}
}

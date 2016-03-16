/**
 * 
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sudhansu
 *
 */
public class MatcherDemo {
	private static final String regex = "\\bdog\\b";
	private static final String input =
			"dog dog dog doggie dogg";
	public static void main(String[] args) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		int c = 0;
		while(m.find()){
			c++;
			//System.out.println(c + " " + m.start() + " "+ m.end());
		}
		lookingAtMatching();
		replaceFirstAndAll();
		replaceAll1();
		appendReplacementTail();
	}
	
	static void lookingAtMatching(){
		String regex = "foo";
		String input = "foooooooooooooo";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		System.out.println(m.lookingAt() + " " + m.matches());
	}
	
	static void replaceFirstAndAll(){
		String regex = "dog";
		String input = "The Dog says hi and the DOg says bye";
		String replace = "cat";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		input = m.replaceAll(replace);
		System.out.println(input);
		
	}
	static void replaceAll1(){
	String	input = "aaabbbfooaabbbfoobbbb";
	String	replace = "-";
	String	regex = "a*b+";
	Pattern p = Pattern.compile(regex);
	Matcher	m = p.matcher(input);
		input = m.replaceAll(replace);
		System.out.println(input);
	}
	static void appendReplacementTail(){
		String	input = "aaabbbfooaabbbfoobbbb";
		String	replace = "-";
		String	regex = "a*b+";
		Pattern p = Pattern.compile(regex);
		Matcher	m = p.matcher(input);
		StringBuffer s = new StringBuffer();
		while(m.find()){
			m.appendReplacement(s, replace);
			
		}
		m.appendTail(s);
		System.out.println(s);
	}
}

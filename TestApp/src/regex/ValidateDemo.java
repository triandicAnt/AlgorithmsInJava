/**
 * 
 */
package regex;

/**
 * @author Sudhansu
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDemo {
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		input.add("123-45-6789");
		input.add("9876-544-4321");
		input.add("987-65-4321 (attack)");
		input.add("987-65-4321 ");
		input.add("1928347465");


		for (String ssn : input) {
			if (ssn.matches("^(\\d{4}-?\\d{1,}-?\\d{4})$")) {
				System.out.println("Found good SSN: " + ssn);
			}
		}
		String s = "I have a dog and a cat.";
		Pattern p = Pattern.compile("mouse|cat|dog|rat|pig");
		//List<String> l = matchPattern(p, s);
		//System.out.println(l.toString());	
		//replaceModify();
		loolAheadBehind();
	}
	// pattern matches
	static List<String> matchPattern(Pattern p, String s){
		Matcher m = p.matcher(s);
		List<String> l = new ArrayList<>();
		while(m.find()){
			System.out.println(m.group());
			l.add(m.group());
		}
		return l;
	}
	static void replaceModify(){
		String input = 
                "User clientId=23421. Some more text clientId=33432. This clientNum=100";

		Pattern p = Pattern.compile("(clientId=)(\\d{1,})");
		Matcher m = p.matcher(input);

		StringBuffer result = new StringBuffer();
		while (m.find()) {
			System.out.println("Masking: " + m.group(2));
			m.appendReplacement(result, m.group(1) + "***masked***");
		}
		m.appendTail(result);
		System.out.println(result);
	}
	
	static void loolAheadBehind(){
		List<String> input = new ArrayList<String>();
		input.add("password");
		input.add("p4ssword");
		input.add("p4ssw0rd");
		input.add("p45sword");

		for (String ssn : input) {
			if (ssn.matches("^(?=.*[0-9].*[0-9])[0-9a-zA-Z]{8,12}$")) {
				System.out.println(ssn + ": matches");
			} else {
				System.out.println(ssn + ": does not match");
			}
		}
	}
}
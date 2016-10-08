package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  -0012a42";
		String s1 ="2147483648";
		String s2 = "+-2";
//		System.out.println(myAtoi(s1));
//		System.out.println(Integer.parseInt(s1));
//		getNextInt(s);
		//Line 19: java.lang.NumberFormatException: For input string: "2147483648"
		parseInteger(s1);
	}
	public static int myAtoi(String str) {
	        str = str.trim();
	        try{
	        if(Integer.valueOf(str)>=Integer.MAX_VALUE || Integer.valueOf(str)<=Integer.MIN_VALUE)
	            return 0;
	        else{
	            int y = Integer.valueOf(str);
	            return y;
	           
	        }}
	        catch(NumberFormatException e){
	    		Matcher m = Pattern.compile("^(\\d+|-\\d+)").matcher(str);
	    		while (m.find()) {
	//    		   System.out.println(m.group(0));
	    			try{
	    				System.out.println(m.group(0));
	    				return Integer.valueOf(m.group(0));
	    			}
	    			catch(NumberFormatException e1){
	    				 return 0;
	    				}
	    			}  	
	    	
	            return 0;
	        }

    }
	public static void getNextInt(String str){
		Matcher m = Pattern.compile("\\d+").matcher(str);
		while (m.find()) {
		   System.out.println(m.group(0));
		}
	}
	public static void parseInteger(String s){
		s = s.trim();
		Matcher m = Pattern.compile("^(\\d+|-\\d+)").matcher(s);
		while (m.find()) {
			   System.out.println(Integer.parseInt(m.group(0)));
			}
	}
}

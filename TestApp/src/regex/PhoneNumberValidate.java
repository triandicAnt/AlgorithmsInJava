import java.lang.Math; // headers MUST be above the first class
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class HelloWorld
{
  public static void main(String[] args)
  {
    /*
    String s1 = "1234567890";
    String s2 = "123-456-7890";
    String s3 = "123-456-78";
    String s4 = "23456789";
    String s5 = "123.345.6789";
    System.out.println(checkNumber(s1));
    System.out.println(checkNumber(s2));
    System.out.println(checkNumber(s3));
    System.out.println(checkNumber(s4));
    System.out.println(checkNumber(s5));
    */
    
  }
  public static boolean checkNumber(String s){
   	Pattern pattern = Pattern.compile("\\d\\d\\d[-]?\\d\\d\\d[-]?\\d\\d\\d\\d");
    Matcher matcher = pattern.matcher(s);
    while(matcher.find()){
      System.out.println(matcher.start());
      System.out.println(matcher.end());
      System.out.println(matcher.group());
      return true;
     }
    return false;
  }
}


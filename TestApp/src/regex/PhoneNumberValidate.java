import java.util.regex.Pattern;
import java.util.regex.Matcher;
// one class needs to have a main() method
public class PhoneNumberValidate
{
  public static void main(String[] args)
  {
    String s1 = "9842029151";
    String s2 = "984-202-9151";
    String s3 = "984-202-91";
    String s4 = "984202151";
    String s5 = "984.202.9151";
    System.out.println(checkNumber(s1));
    System.out.println(checkNumber(s2));
    System.out.println(checkNumber(s3));
    System.out.println(checkNumber(s4));
    System.out.println(checkNumber(s5));
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


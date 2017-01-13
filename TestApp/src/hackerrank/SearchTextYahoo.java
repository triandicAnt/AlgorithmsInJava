/**
 * 
 */
package hackerrank;

/**
 * @author Sudhansu
 *
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SearchTextYahoo {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = br.readLine();
                if(input == null)
                    break;
                list.add(input);
            }
          if(list.size()==0)
            return;
          
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m;
        for(String s : list){
            m = p.matcher(s);
            if(m==null)
              continue;
            StringBuffer sb = new StringBuffer();
            while(m.find()) {
                //System.out.println(m.group(1));
                sb.append(m.group(1));
                sb.append(",");
            }
            if(sb.length()>0)
                System.out.println(sb.toString().substring(0,sb.length()-1));
            else
                System.out.println("");
        }
      
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
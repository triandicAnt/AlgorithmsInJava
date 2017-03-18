import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVParser {
	 public static void main(String[] args)
	  {

	    String s = "aaa\",\"b\"\"bb\",\"ccc";
	   // System.out.println(s);
	   // System.out.println(Arrays.toString(s.split("\",\"")));
	    parseCSV("C:\\Users\\sud\\Downloads\\test.csv");
	    
	  }
	  public static void parseCSV(String fileName){
		  System.out.println(fileName);
	   	String line = "";
	    String pattern = "\",\"";
	    String patternDefault = ",";
	    
	    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
	      while((line = br.readLine())!=null){
	        	String []data = line.split(pattern);
	        	System.out.println(Arrays.toString(data));
	      }
	    }catch(IOException e){
	     	e.printStackTrace(); 
	    }
	  }
	}

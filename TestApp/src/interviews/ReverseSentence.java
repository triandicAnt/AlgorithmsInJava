package interviews;

public class ReverseSentence {
	  public static void main(String[] args)/* throws IOException*/ {
//	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	    String s;
//	    StringBuffer sb = new StringBuffer();
//	    while ((s = in.readLine()) != null) {
//	      sb.append(s);
//	    }
//	    String s1 = sb.toString();
		String s1 = "Hello Watson";
	    String inputString = s1.toLowerCase();


	        String[] words = inputString.split(" ");
	        for(int i = 0; i < words.length / 2; i++)
			{
			    String temp = words[i];
			    words[i] = words[words.length - i - 1];
			    words[words.length - i - 1] = temp;
			}

	        String reverseString = "";

	        for (int i = 0; i < words.length; i++)
	        {
	            String word = words[i];

	            String reverseWord = "";

	            for (int j = word.length()-1; j >= 0; j--)
	            {
	                reverseWord = reverseWord + word.charAt(j);
	            }

	            reverseString = reverseString + reverseWord + " ";
	        }
	         String cap = toTitleCase(reverseString);
	        System.out.println(cap);

	  }
	 public static String toTitleCase(String givenString) {
	    String[] arr = givenString.split(" ");
	    StringBuffer sb = new StringBuffer();

	    for (int i = 0; i < arr.length; i++) {
	        sb.append(Character.toUpperCase(arr[i].charAt(0)))
	            .append(arr[i].substring(1)).append(" ");
	    }
	    return sb.toString().trim();
	}

	}
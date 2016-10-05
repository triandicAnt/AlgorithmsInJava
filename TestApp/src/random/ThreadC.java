package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadC {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleDemo A = new SampleDemo("A");
		SampleDemo B = new SampleDemo("B");
		
//		B.start();
//		A.start();
		
		HashSet<String> set = new HashSet<>();
		String [] str = new String [5];
		str[0] = "hello how";
		str[1] = "how";
		System.out.println(Arrays.toString("Hello how".split("\\s")));
//		for(String s: str){
//			String [] temp = s.split("\\s");
//			for(String s1 : temp){
//				set.add(s1);
//			}
//		}
//		int x = set.size();
//		ArrayList<String> arr = new ArrayList<>();
//		for(String s2: str){
//			String [] temp1 = s2.split("\\s");
//			boolean flag = false;
//			int c = x;
//
//			for(String s3 : temp1){
//				if(!set.contains(s3)){
//					flag = true;
//					break;
//				}else{
//					c--;
//				}
//			}
//			if(flag == false && c==0){
//				arr.add(s2);
//			}
//		}
//		System.out.println(arr);
		
		System.out.println(reverseWords("Hello watson"));

	}
	public static String reverse(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		/**
		 * Hello Watson
		 * olleh nostaW
		 * Watson Hello
		 * 
		 */
		String reverseString = "hello works";
		String [] tempArr = reverseString.split("\\s");
		StringBuffer sb = new StringBuffer();
		for(String stringTemp: tempArr){
			sb.append(stringTemp.substring(0, 1).toUpperCase() + stringTemp.substring(1));
		}
		System.out.println(sb.toString());
		return sb.toString();
		
	}
	

	
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	
	
}

class SampleDemo implements Runnable{
	private Thread t;
	private String threadName;
	
	SampleDemo(String threadName){
		this.threadName = threadName;
	}
	public void run(){
		while(true){
			System.out.println(threadName);
		}
	}
	public void start(){
		if(t == null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

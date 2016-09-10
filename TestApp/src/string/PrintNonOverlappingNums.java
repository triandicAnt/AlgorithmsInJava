package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
public class PrintNonOverlappingNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int []{1,2,3,4};
		StringBuffer sb = new StringBuffer();
		for(int i :a){
			sb.append(i);
		}
		//permute(sb.toString(), "");
		int a1 = 1;
		int b = a1++;
		int c = ++b;
		System.out.println(a1 + "" +b + "" +c);

	}
	
	/**
	 * (1234)
	   (1)(234)
	   (1)(2)(34)
	   (1)(2)(3)(4)
	   (1)(23)(4)
	   (12)(34)
	   (12)(3)(4)
	   (123)(4)
	 * @param number
	 * @param prefix
	 */
	static void permute(String number, String prefix){
		System.out.println(prefix+"("+number+")");
		
		for(int i = 1; i<number.length();i++){
			String newPrefix = prefix+"("+number.substring(0, i)+")";
			permute(number.substring(i, number.length()), newPrefix);
		}
	}
	
}


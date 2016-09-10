package string;

public class PrintNonOverlappingNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int []{1,2,3,4};
		StringBuffer sb = new StringBuffer();
		for(int i :a){
			sb.append(i);
		}
		permute(sb.toString(), "");

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

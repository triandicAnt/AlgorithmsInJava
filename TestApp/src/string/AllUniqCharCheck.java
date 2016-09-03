package string;

public class AllUniqCharCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allUniqChar("asa"));
		char[] c = {'h','e','l','l','o'};
		System.out.println(reverseString("helslo"));
		for (int i = 0; i < c.length; i++) {
			System.out.println(i);
		}
		
	}
	
	static boolean allUniqChar(String str){
		int check = 0;
		for(int i=0; i<str.length();i++){
			int val = str.charAt(i) - 'a';
			if((check &(1<<val))>0){
				return false;
			}
			check = check | (1<<val);
 		}
		return true;
	}
	
	
	static String reverseString(String str){
		
		char []c = str.toCharArray();
		int n = str.length()/2;
		int l = str.length();
		for(int i=0; i<n; i++){
			swap(c, i, l-i-1);
		}
		return String.valueOf(c);
	}
	
	static void swap(char []c, int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

}

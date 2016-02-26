
public class AddSubtractNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(5, 6));
		System.out.println(min(5,15));
		System.out.println(getMaximum(3, 12));

	}
	
	static int subtract(int x, int y){
		y = (~y) + 1;
		while(y!=0){
			int carry = x&y;
			x = x^y;
			y = carry<<1;
		}
		return x;
	}
	static int add(int x, int y){
		while(y!=0){
			int carry = x&y;
			x = x^y;
			y = carry<<1;
		}
		return x;
	}
	static int max(int a, int b){
		return (a^((a^b)& -(a<b?1:0)));
	}
	static int min(int a, int b){
		return (b^((a^b)& -(a<b?1:0)));
	}
	static int getMaximum(int a, int b){
		int c = a-b;
		int k = (c>>31)&0x1;
		return (a-k*c);
	}

}

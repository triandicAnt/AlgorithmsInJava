package bits;

public class BitsToFlip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--");
		System.out.println(countBitsToFlip(73, 21));
		System.out.println("--");

	}
	
	static int countBitsToFlip(int a, int b){
		int c = a^b;
		int count = 0;
		while(c>0){
			if(((c>>1)&1) >0)
				count ++;
			c = c>>1;
		}
		return count;
	}

}

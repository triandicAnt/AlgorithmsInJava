package random;

public class CommonElements {
	
	public static void main(String[] args) {
		System.out.println("Hello Java!!");
		System.out.println("Count is "+ countNumberOfElems(1, 1, 2, 2, 1000000000));
	}
	
	public  static long countNumberOfElems(int A, int D, int B, int R, int lim){
		long ap = A;
		long gp = B;
		long count = 0;
		while(ap<=lim && gp<=lim){
			if(ap ==gp){
				count = count +1;
				ap = ap +D;
				gp = gp*R;
			}
			else if(ap<gp){
				ap = ap +D;
			}
			else if (ap>gp){
				gp = gp*R;
			}
		}
		
		return count;
	}
}

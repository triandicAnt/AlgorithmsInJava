
public class CalculatePi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x = System.currentTimeMillis();
		System.out.println(calculatePi());
		System.out.println(System.currentTimeMillis()-x);

	}
	public  static double calculatePi(){
		int max = Integer.MAX_VALUE-1;
		double noOfSuccess = 0;
		double total = 0;
		for(int i = 0 ;i<=max; i++){
			double x = Math.random();
			double y = Math.random();
			if((x*x + y*y)<=1){
				noOfSuccess++;
			}
			total++;
		}
		double pi = 4*(noOfSuccess/total);
		return pi;
	}

}

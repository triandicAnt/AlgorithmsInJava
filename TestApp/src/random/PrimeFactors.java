package random;

public class PrimeFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPrime(10);
		System.out.println();
		printPrimeFactors(6);


	}
	static void printPrime(int num){
		 for(int i = 2; i<=num;i++){
			 boolean flag = false;
			 for(int j = 2;j*j<=i;j++){
				 if(i%j==0)
				 {
					 flag = true;
					 break;
				 }
			}
			 if(!flag)
				 System.out.print(i + " ");
			 }
		 }
	 
	 static void printPrimeFactors(int num){
		 while(num%2==0){
			 System.out.print(2 + " ");
			 num = num/2;
		 }
		 for(int i = 3; i*i<=num; i= i+2){
			 if(num%i==0){
				 System.out.print(i + " ");
				 num = num/i;
			 }
		 }
		 if(num>2)
			 System.out.print(num);
	}
}

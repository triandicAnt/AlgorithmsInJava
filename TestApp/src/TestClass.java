import java.util.Scanner;


public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a = 0.1f;
		float Bi=500;
		int c=0;
		Scanner scanner = new Scanner(System.in);
		while(a!=0)
		{
			if(a>=1 || a<=0)
				break;
			System.out.println("Enter the value of a: " );
			a=scanner.nextFloat();
			float Ri=0;
			float Rj=150;
			c=0;
			while(Ri<=250)
			{
				Ri = Rj*a + (1-a)*Bi;
				Rj=Ri;
				c++;
			}
			System.out.println("Count of observations for a = "+a+" : "+c);
		}
		scanner.close();
	
	}

}

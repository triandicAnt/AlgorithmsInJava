/**
 * 
 */
package random;

/**
 * @author Sudhansu
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(5));
		System.out.println(fibonacci(6));

	}
	static int fibonacci(int n){
		
		int fib[] = new int [n+1];
		fib[0] = fib[1] = 1;
		//if()
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		return fib[n];
	}
}

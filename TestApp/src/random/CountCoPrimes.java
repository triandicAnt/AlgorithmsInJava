/**
 * 
 */
package random;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class CountCoPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountCoPrimes c = new CountCoPrimes();
		int [] a = new int []{5,100,8,6,23,6};
		System.out.println(Arrays.toString(a));
		int [] b = c.populateCoPrimes(a);
		System.out.println(Arrays.toString(b));

	}
	/**
	 * 
	 * @param first number a
	 * @param second number b
	 * @return gcd
	 */
	int calculateGCD(int a, int b){
		if(a==0 || b== 0)
			return a+b;
		else
			return calculateGCD(b, a%b);
	}
	/**
	 * 
	 * @param number a
	 * @return count of coprimes
	 */
	int countCoPrimes(int a){
		int counter=0;
		for(int i=1;i<=a;i++){
			if(calculateGCD(i, a)==1)
				counter ++;
		}
		return counter;
	}
	/**
	 * 
	 * @param array a
	 * @return a new array consisting of prime factorss
	 */
	int [] populateCoPrimes(int [] a){
		int []b = new int [a.length];
		int j=0;
		for(int i : a){
			b[j] = countCoPrimes(i);
			j++;
		}
		return b;
	}
}

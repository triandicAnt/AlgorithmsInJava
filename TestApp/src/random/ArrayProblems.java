/**
 * 
 */
package random;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Sudhansu
 *
 */
public class ArrayProblems {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] n = new int[]{ 2, 3, 1, -2, -1, 2, 1,-3, 0 };
		ArrayProblems ap = new ArrayProblems();
		//ap.findNumbers(n);
		//ap.findTriplerts(n);
		ap.findTripletWithSumS(n, 0);
	}
	/**
	 * Find three numbers in an arrays whose sum is zero.
	 */
	/**
	 * 
	 * @param n
	 */
	void findNumbers(int [] n){
		Arrays.sort(n);
		HashSet<Integer> hs = new HashSet<>();
		for (int i : n) {
			hs.add(i);
		}
		HashSet<Nums> hmap = new HashSet<>();
		for (int i = 0; i < n.length; i++) {
			for (int j = i; j < n.length; j++) {
				if(hs.contains(-1*(n[i]+n[j]))){
					Nums p = new Nums();
					p.arr[0] = n[i];
					p.arr[1] = n[j];
					p.arr[2] = -1*(n[i]+n[j]);
					hmap.add(p);
				}
			}
		}
		
		// print the pairs
		for(Nums num: hmap){
			System.out.println(num.toString());
		}
	}
	
	/**
	 * 
	 * @param n
	 */
	void findTriplerts(int [] n){
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < n.length; i++) {
			int s1 = 0-n[i];
			for (int j = 0; j <=i ; j++) {
				int s2 = s1-n[j];
				if(hs.contains(s2))
				{
					System.out.println(n[i] + " "+ n[j] + " "+ s2);
				}
			}
			hs.add(n[i]);
		}
	}
	/**
	 * 
	 * @param n
	 * @param s
	 */
	void findTripletWithSumS(int [] n, int s){
		Arrays.sort(n);
		int j,k=0;
		for (int i = 0; i < n.length-2; i++) {
			k=n.length-1;
			j=i+1;
			while(k>=j) {
				if(n[i]+n[j]+n[k] == s){
					System.out.println(n[i] + " "+ n[j] + " "+ n[k]);		
				}
				if(n[i]+n[j]+n[k] >s){
						k--;	
				}else
					j++;
			}
		}
	}
	

}
class Nums{
	int arr[];
	/**
	 * 
	 */
	public Nums() {
		// TODO Auto-generated constructor stub
		arr = new int [3];
	}
	
	
	@Override
	public int hashCode() {
		return this.arr[0]*2 + this.arr[1]*3 + this.arr[2]*4+ 43;
	}

	@Override
	public boolean equals(Object obj) {
		Nums n = (Nums)obj;
		return (this.arr[0]==n.arr[0] &&
				this.arr[1]==n.arr[1] &&
				this.arr[2]==n.arr[2]);
		}
	
	@Override
	public String toString() {
		return (this.arr[0] + " " + this.arr[1] + " " + this.arr[2]);
	}
}

/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/bulb-switcher/
 */
public class BulbSwitcher {
	public static void main(String[] args) {
		System.out.println(2&3);
	}
	   public int bulbSwitch(int n) {
		   /*  if(n==0)
		         return 0;
		     else if(n<=5){
		          return 1;
		      }else{
		          return n%5;
		      }  */
		      return (int)Math.sqrt(n);
		     }
}

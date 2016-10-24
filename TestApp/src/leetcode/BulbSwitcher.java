/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class BulbSwitcher {
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

/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class ValidPerfectSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(202051*202051);
		System.out.println(isPerfectSquare(64));
	}
	
	 public static boolean isPerfectSquare(int num) {
	        if(num==1)
	            return true;
	        long l=1;
	        //do binary search of the squre root
	        return binarySearch(num,l,num);
	    }
	    public static boolean binarySearch(long num, long l, long h){
	        long m = l+(h-l)/2;
	    	System.out.println(l+ " "+m+" "+h);
	        
	        if(l>=h || l==m && m*m!=num)
	            return false;
	        if(m<0)
	            return false;
	        if(m*m==num)
	            return true;
	        if(m*m>num || m*m<0)
	            return binarySearch(num,l,m);
	        else 
	            return binarySearch(num,m,h);
	    }

}

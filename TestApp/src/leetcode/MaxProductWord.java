/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class MaxProductWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s [] = {"abcw","baz","foo","bar","xtfn","abcdef"};
		System.out.println(maxProduct(s));
	}
	
	  public static int maxProduct(String[] words) {
	        if(words==null || words.length<=1)
	            return 0;
	        int n = words.length;
	        int [] arr = new int [n];
	        for(int i=0;i<n;i++){
	            String s = words[i];
	            for(char c:s.toCharArray()){
	                arr[i] = arr[i] | (1<<(c-'a'));    
	            }
	        }
	        System.out.println(Arrays.toString(arr));
	        int max = 0;
	        for(int i =0;i<n;i++){
	            for(int j = i+1; j<n;j++){
	                if((arr[i]&arr[j]) == 0 && words[i].length()*words[j].length()>max){
	                    max = words[i].length()*words[j].length();
	                }
	            }
	        }
	        return max;
	        
	    }

}

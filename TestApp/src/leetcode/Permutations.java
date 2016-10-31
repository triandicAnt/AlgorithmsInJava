/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public List<List<Integer>> permute(int[] nums) {
	        if(nums == null || nums.length<=0)
	            return null;
	        StringBuffer sb = new StringBuffer();
	        for(int a:nums){
	            sb.append(a);
	        }
	               // System.out.println(sb.toString());
	        List<String> strList = permuteString(sb.toString());
	        if(strList == null)
	            return null;
	        List<List<Integer>> list = new ArrayList<>();
	        //System.out.println(strList);
	        for(String s:strList){
	            List<Integer> l = new ArrayList<Integer>();
	            for(int i = 0; i<s.length();i++){
	                l.add(Character.getNumericValue(s.charAt(i)));
	            }
	            list.add(l);
	        }
	        return list;
	    }
	    // string permutation
	    public List<String> permuteString(String str){
	        if(str==null || str.length()<0)
	            return null;
	        List<String> list = new ArrayList<String>();
	        if(str.length()==0){
	            list.add("");
	            return list;
	        }
	        char c = str.charAt(0);
	        List<String> remList = permuteString(str.substring(1));
	        for(String s: remList){
	            for(int i=0;i<=s.length();i++){
	                String sTemp = getCombination(s,i,c);
	                list.add(sTemp);
	            }
	        }
	       // System.out.println("---" + list);
	        return list;
	    } 
	    
	    // get
	    public String getCombination(String s, int i, char c){
	        StringBuffer sb = new StringBuffer();
	        sb.append(s.substring(0,i));
	        if(s.indexOf(c)==-1)
	            sb.append(c);
	        sb.append(s.substring(i, s.length()));
	        return sb.toString();
	    }
	   

}

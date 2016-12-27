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
public class PalindromePartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartition p = new PalindromePartition();
		String s = "aab";
		System.out.println(p.partition(s));

	}
	 public List<List<String>> partition(String s) {
	        List<List<String>> list = new ArrayList<>();
	        if(s==null || s.length()==0)
	            return list;
	        getPalin(s,list,new ArrayList<String>(),0);
	        System.out.println("Here");
	        return list;
	    }
	    public void getPalin(String s, List<List<String>> list, List<String> temp, int l){
	    	System.out.println("called");
	        if(temp.size()>0 && l>=s.length()){
	            System.out.println(temp);
	            list.add(new ArrayList<>(temp));
	            return;
	        }
	        for(int i=l;i<s.length();i++){
	        	System.out.println(i+"-------");
	            if(isPalindrome(s,l,i)){
	                if(i==l)
	                    temp.add(""+s.charAt(i));
	                else
	                    temp.add(s.substring(l,i+1));
	                getPalin(s,list,temp,i+1);
	                temp.remove(temp.size()-1);
	            }else
	            	System.out.println("np");
	        }
	    }
	    public boolean isPalindrome(String s, int l, int r){
	        if(l==r)
	            return true;
	        while(l<r){
	            if(s.charAt(l)!=s.charAt(r))
	                return false;
	            l++;
	            r--;
	        }
	        return true;
	    }

}

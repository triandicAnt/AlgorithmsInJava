/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sudhansu
 *
 */
public class Permutations {

	/**
	 * @param args
	 * Failing incase of a negative number
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length<=0)
            return null;
       
       /* StringBuffer sb = new StringBuffer();
        for(int a:nums){
            sb.append(a);
        }
               // System.out.println(sb.toString());
        Set<String> strList = permuteString(sb.toString());
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
        return list;*/
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }
    // string permutation
    public Set<String> permuteString(String str){
        if(str==null || str.length()<0)
            return null;
        Set<String> list = new HashSet<String>();
       // List<String> list = new ArrayList<String>();
        if(str.length()==0){
            list.add("");
            return list;
        }
        char c = str.charAt(0);
        Set<String> remList = permuteString(str.substring(1));
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
    
    public void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums){
        if(nums.length == temp.size()){
            list.add(new ArrayList<>(temp));
        }else{
            for(int i =0 ;i<nums.length;i++){
                if(temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backtrack(list,temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

}

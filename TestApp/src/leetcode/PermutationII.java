/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class PermutationII {
	public class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
	        if(nums.length<=0)
	            return list;
	        Arrays.sort(nums);
	        boolean [] used = new boolean[nums.length];
	        dfs(nums,list,new ArrayList<Integer>(), used);
	        return list;
	    }
	    public void dfs(int [] nums, List<List<Integer>> list, List<Integer> l, boolean [] used){
	        if(l.size()==nums.length){
	            list.add(new ArrayList<>(l));
	            return;
	        }
	        for(int i=0; i<nums.length;i++){
	            if(used[i]==false){
	                if(i>0 && nums[i] == nums[i-1] && used[i-1]==true)
	                    continue;
	                used[i] = true;
	                l.add(nums[i]);
	                dfs(nums,list,l, used);
	                used[i] = false;
	                l.remove(l.size()-1);
	            }
	        }
	    }
	}
}

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
public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(candidates);
	        dfs(candidates, target, 0,0,result, new ArrayList<Integer>());
	        return result;
	    }
	    public void dfs(int [] candidates, int target, int start, int sum,List<List<Integer>> result, List<Integer> list){
	        if(target == sum){
	            System.out.println(list);
	            result.add(new ArrayList<Integer>(list));
	        }
	        for(int i=start; i<candidates.length;i++){
	            if(sum+candidates[i]>target)
	                break;
	            list.add(candidates[i]);
	            dfs(candidates, target,i,sum+candidates[i],result,list);
	            list.remove(list.size()-1);
	        }
	    }
}

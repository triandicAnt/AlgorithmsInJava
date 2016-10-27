/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> list = new ArrayList<>();
	        int [] arr = {1,2,3,4,5,6,7,8,9};
	       
	        allSubSet(arr,0,0,n,"",list,k);
	        return list;
	        
	    }
	     public void allSubSet(int []arr, int index,int cur,  int sum, String result, List<List<Integer>> list,int k){
			if(arr.length < index || cur>sum)
				return;
			for(int i = index; i< arr.length; i++){
				if(cur + arr[i] == sum){
				    List<Integer> l = new ArrayList<>();
				    for(char c: result.toCharArray()){
				        l.add(Character.getNumericValue(c));
				    }
				    l.add(arr[i]);
				    if(l.size()==k)
				        list.add(l);
				//	System.out.println(result + " " + arr[i]);
				}
				else if(cur + arr[i]<sum){
					allSubSet(arr, i+1, cur+arr[i], sum, result + arr[i], list,k);
				}
			}
		}
}

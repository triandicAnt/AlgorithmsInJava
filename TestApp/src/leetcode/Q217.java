/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author Sudhansu
 *
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<=1)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a:nums){
            if(map.containsKey(a)){
                //if(map.get(a)>=1)
                    return true;
               // map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        return false;
    }
}
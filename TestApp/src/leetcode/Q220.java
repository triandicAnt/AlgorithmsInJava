/**
 * 
 */
package leetcode;

import java.util.TreeSet;

/**
 * @author Sudhansu
 *
 */
public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0 || k==0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        // for(int i = 0 ; i<nums.length;i++){
        //     Long floor = set.floor((long)(nums[i]));
        //     Long ceil = set.ceiling((long)(nums[i]));
        //     System.out.println(floor + " " + ceil);
        //     System.out.println(nums[i]);
        //     if((floor!=null && nums[i]-floor>=nums[i]) || (ceil!=null && ceil-nums[i]<= nums[i]))
        //         return true;
        //     set.add((long)nums[i]);
        //     System.out.println(set);
        //     if(i>k)
        //         set.remove((long)nums[i-k]);
        // }
        // return false;
        int i = 0;
	while (i < nums.length) {
		Long floor = set.floor((long) nums[i]);
		Long ceiling = set.ceiling((long) nums[i]);
		if ((floor != null && nums[i] - floor <= t ) ||
				(ceiling != null && ceiling - nums[i] <= t)) {
			return true;
		}
		set.add((long) nums[i++]);
		if (i > k) {
			set.remove((long) nums[i - k - 1]);
		}
	}
	return false;
    }
}
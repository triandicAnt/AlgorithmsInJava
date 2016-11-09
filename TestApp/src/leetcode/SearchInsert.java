/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
        // do binary search
        // handle edge cases
        if(nums == null || nums.length<=0)
            return -1;
        int l = 0;
        int h = nums.length -1;
        // 2nd edge case
        if(nums[0] >= target)
            return 0;
        if(nums.length==1 && nums[0] < target)
            return 1;
        
        // find the index to insert
        
        int index = findIndex(nums, target, l, h);
        return index;
    }
    public int findIndex(int [] nums, int target, int l, int h){
        // handle edge case
        if(l>h)
            return l;
        if(l==h && target<=nums[l])
            return l;
        if(l==h && target>nums[l])
            return h+1;
        int mid = l + (h-l)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] > target)
            return findIndex(nums, target, l, mid-1);
        else
            return findIndex(nums, target, mid+1, h);
    }
}

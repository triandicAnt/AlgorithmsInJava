public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        return searchTarget(nums, l,h,target);
    }
    public int searchTarget(int [] nums, int l, int h, int target){
        if(l>h)
            return -1;
        int m = (l+h)/2;
        if(nums[m]==target)
            return m;
        // check if the left half is sorted
        if(nums[l]<=nums[m]) {// left half is sorted
            // check if target fits in that range
            if(nums[l]<=target && nums[m]>target){
                // target falls in this range
                return searchTarget(nums,l,m-1,target);
            }else{
                return searchTarget(nums,m+1,h,target);
            }
        }else if(nums[m]<=nums[h]){ // right side is sorted
            if(nums[m]<target && nums[h]>=target){
                // target falls in this range
                return searchTarget(nums,m+1,h,target);
            }else{
                return searchTarget(nums,l,m-1,target);
            }
        }
        return -1;
    }
}

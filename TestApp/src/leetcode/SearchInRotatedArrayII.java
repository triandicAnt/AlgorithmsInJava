public class SearchInRotatedArrayII {
    public boolean search(int[] nums, int target) {
        return searchTarget(nums,0,nums.length-1,target);
    }
    public boolean searchTarget(int [] nums,int l, int h, int target){
        if(l>h)
            return false;
        int m = l + (h-l)/2;
        if(nums[m] == target)
            return true;
        
        //check which side is the taget
        if(nums[l]< nums[m]){ // right side is sorted
            if(nums[l]<=target && nums[m]>target){
               return searchTarget(nums, l,m-1,target);
            }else{
                return searchTarget(nums,m+1,h,target);
            }
        }else if(nums[m]<nums[h]){
              if(nums[m]<target && nums[h]>=target){
               return searchTarget(nums, m+1,h,target);
            }else{
                return searchTarget(nums,l,m-1,target);
            }
        }else{
            boolean x = searchTarget(nums, l,m-1,target);
            if(x==false)
                return searchTarget(nums,m+1,h,target);
            return x;
        }
    }
}

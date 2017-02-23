public class SearchInRotated {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        return search(nums, target,0,nums.length-1);
    }
    public int search(int[]nums, int target, int l, int h){
        if(l>h)
            return -1;
        int mid = (l+h)/2;
        if(nums[mid]==target)
            return mid;
        //check if left half is sorted
        if(nums[l]<nums[mid]){
            if(nums[l]<=target && nums[mid]>target)
                return search(nums,target, l, mid-1);
            else 
                return search(nums,target, mid+1, h);
        }else if(nums[l]>nums[mid]) {//right half is sorted
            if(nums[mid]<target && nums[h]>= target)
                return search(nums,target, mid+1, h);
            else
                return search(nums,target, l, mid-1);
        }else if(nums[l] == nums[mid]){
            if(nums[mid]!=nums[h])
                 return search(nums,target, mid+1, h);
            else{
                int x  = search(nums,target, l, mid-1);
                if(x==-1)
                     return search(nums,target,mid+1,h);
                else
                    return x;
            }
        }
        return -1;
    }
}

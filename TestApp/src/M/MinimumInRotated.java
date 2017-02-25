public class MinimumInRotated {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        return find(nums,0,nums.length-1);
    }
    public int find(int [] nums, int l , int h){
        if(l>h)
            return  nums[l];
        int mid = (l+h)/2;
        if(mid>0 && mid<h && nums[mid-1]>nums[mid] && nums[mid+1]> nums[mid])
            return nums[mid];
        else if(nums[h]<nums[mid]){// left is sorted
            return find(nums,mid+1, h);
        }else{
            return find(nums,l,mid-1);
        }
       // return -1;
    }
}

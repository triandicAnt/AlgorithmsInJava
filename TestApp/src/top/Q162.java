public class Q162 {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        return search(nums, 0, nums.length-1);
    }
    public int search(int []nums, int l, int h){
        if(l==h)
            return l;
        int mid1 = l+(h-l)/2;
        int mid2 = mid1+1;
        if(nums[mid1]>nums[mid2])
            return search (nums, l, mid1);
        return search(nums, mid2, h);
    }
}

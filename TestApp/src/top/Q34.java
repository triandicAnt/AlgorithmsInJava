public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1,-1};
        if(nums==null || nums.length==0)
            return res;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]<target)
                i = mid+1;
            else
                j = mid;
        }
        if(nums[i]!=target)
            return res;
        res[0] = i;
        j = nums.length-1;
        while(i<j)
        {
            int mid = (i+j)/2 +1;
            if(nums[mid]>target)
                j = mid-1;
            else
                i = mid;
        }
        if(nums[i]!=target)
            res[1] = res[0];
        else
            res[1] = i;
        return res;
        
    }
}

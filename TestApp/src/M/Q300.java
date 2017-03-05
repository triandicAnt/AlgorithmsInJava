public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int []tail = new int[nums.length];
        int size = 0;
        for(int x : nums){
            int i = 0;
            int j = size;
            while(i!=j){
                int mid = (i+j)/2;
                if(tail[mid]<x)
                    i = mid+1;
                else
                    j = mid;
            }
            tail[i] = x;
            if(i==size)
                size+=1;
        }
        return size;
    }
}

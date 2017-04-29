public class Q300 {
    public int lengthOfLIS(int[] nums) {
     if(nums==null || nums.length==0)
        return 0;
     int[] temp = new int [nums.length];
     Arrays.fill(temp, 1);
     for(int i = 1; i<nums.length;i++){
         for(int j = 0; j<i;j++){
             if(nums[i]>nums[j])
                temp[i] = Math.max(temp[i], temp[j]+1);
         }
     }
     int max = 0;
     for(int i:temp)
    {
        if(i>max)
            max = i;
    }    
    return max;
    }
}

public class Q377 {
    int count = 0;
    int [] dp;
    public int combinationSum4(int[] nums, int target) {
        if(target <= 0)
            return 1;
       // int count = 0;
        // dfs(nums,0, target,0);
        // return count;
        // int res = 0;
        // for(int i =0; i<nums.length;i++){
        //     if(target>=nums[i])
        //         res += combinationSum4(nums, target-nums[i]);
        // }
        // return res;
        dp = new int[target+1];
                Arrays.fill(dp, -1);

        dp[0] = 1;
        return sum(nums,target);
    }
    
    public int sum(int [] nums, int target)
    {
        if(dp[target]!=-1)
            return dp[target];
        int res = 0;
        for(int i =0;i<nums.length;i++){
            if(target>=nums[i])
                res += sum(nums, target-nums[i]);
        }
        dp[target] = res;
        return res;
    }
    
    
    
    public void dfs(int [] nums, int sum, int target, int count){
        if(sum == target){
            count +=1;
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(sum>target)
                continue;
            sum = sum + nums[i];
            dfs(nums, sum, target, count);
            sum = sum - nums[i];
        }
        
    }
}

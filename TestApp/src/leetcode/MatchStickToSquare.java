package leetcode;

import java.util.Arrays;

public class MatchStickToSquare {
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4)
            return false;
        int sum = 0;
        for(int a: nums)
            sum+=a;
        if(sum%4!=0)
            return false;
        Arrays.sort(nums);
        reverseArray(nums);
        System.out.println(Arrays.toString(nums));
        int sums[] = new int [4];
        return dfs(nums,sums,0,sum/4);
    }
    public boolean dfs(int [] nums, int [] sum, int index, int target){
        if(index == nums.length){
            if(sum[0]==target && sum[1]==target && sum[2]==target)
                return true;
            return false;
        }
        for(int i=0;i<4;i++){
            if(sum[i]+nums[index]>target)
                continue;
            sum[i] +=nums[index];
            if(dfs(nums,sum,index+1,target)==true)
                return true;
            sum[i]-=nums[index];
        }
        return false;
    }
    public void reverseArray(int []a){
        int l=0;
        int h = a.length-1;
        while(h>l){
            int temp = a[l];
            a[l] = a[h];
            a[h] = temp;
            l++;
            h--;
        }
    }
}

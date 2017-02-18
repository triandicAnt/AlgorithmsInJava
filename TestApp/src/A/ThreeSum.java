public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;
        threeSum(list, 0, nums);
        return list;
    }
    public void threeSum(List<List<Integer>> list, int sum, int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int j,k;
        for(int i = 0; i<n-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                j = i+1;
                k = n-1;
                int s= sum-nums[i];
                while(j<k){
                    if(nums[j]+nums[k]==s){
                        list.add(Arrays.asList(nums[i], nums[j],nums[k]));
                        while(j<k && (nums[j]==nums[j+1]))
                            j++;
                        while(j<k && (nums[k]==nums[k-1]))
                            k--;
                        j++;
                        k--;
                    }else if(nums[j]+nums[k]>s){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
    }
    
}

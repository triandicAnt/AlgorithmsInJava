public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        return search(nums, 0, list);
    }
    public List<List<Integer>> search(int[] nums, int sum, List<List<Integer>> list){
        for(int i = 0; i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            int s = sum - nums[i];
            if(i==0 || (nums[i]!=nums[i-1])){
                while(j<k){
                    //System.out.println(nums[j]+nums[k] + " " + s);
                    if(nums[j]+nums[k]==s){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1])
                            j++;
                        while(j<k && nums[k]==nums[k-1])
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
        return list;
    }
}

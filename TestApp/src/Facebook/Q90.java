public class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;
        Arrays.sort(nums);
        permute(list, new ArrayList<Integer>(),nums,0);
        return list;
    }
    public void permute(List<List<Integer>> list, List<Integer> temp, int []nums, int index){
        list.add(new ArrayList<>(temp));
        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            permute(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}

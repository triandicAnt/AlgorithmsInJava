public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length == 0)
            return list;
        Arrays.sort(nums);
        backtrack(nums, list, new ArrayList<>());
        return list;
    }
    public void backtrack(int [] nums, List<List<Integer>> list, List<Integer> temp){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0 ; i<nums.length;i++){
            if(temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            backtrack(nums, list, temp);
            temp.remove(temp.size()-1);
        }
    }
}

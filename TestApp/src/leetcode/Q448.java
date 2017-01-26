public class Q448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;
        for(int a : nums){
            int val = Math.abs(a);
            val-=1;
            if(nums[val]>0){
                nums[val] = -nums[val];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}

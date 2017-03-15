public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || k<0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        // int j=0;
        // for(int i:nums)
        //     map.put(i,j++);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])!=i && Math.abs(i-map.get(nums[i]))<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}

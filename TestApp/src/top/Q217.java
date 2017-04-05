public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<=1)
            return false;
       Map<Integer, Integer> map = new HashMap<>();
       for(int i:nums){
           if(map.containsKey(i))
                return true;
            map.put(i,1);
       }
       return false;
    }
}

public class Q128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       int count  = 0;
       for(int i : nums){
           if(!map.containsKey(i)){
               int l = map.containsKey(i-1)?map.get(i-1):0;
               int r = map.containsKey(i+1)?map.get(i+1):0;
               int max = l+r+1;
               count = Math.max(count, max);
               map.put(i,max);
               map.put(i-l,max);
               map.put(i+r,max);
           }
       }
       return count;
    }
}

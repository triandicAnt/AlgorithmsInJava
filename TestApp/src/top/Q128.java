public class Q128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null ||nums.length==0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int a : nums){
            if(map.get(a)==null){
            int l = map.get(a-1)!=null?map.get(a-1):0;
            int r = map.get(a+1)!=null?map.get(a+1):0;
            int max = l+r+1;
            count = Math.max(count, max);
            map.put(a,max);
            map.put(a-l,max);
            map.put(a+r,max);
            }
        }
        return count;
    }
}

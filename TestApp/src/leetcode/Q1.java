public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int [2];
        if(nums==null || nums.length ==0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int a : nums){
            if(map.containsKey(target-a)){
                res[1] = i;
                res[0] = map.get(target-a);
            }
            map.put(a,i);
            i++;
        }
        return res;
    }
}

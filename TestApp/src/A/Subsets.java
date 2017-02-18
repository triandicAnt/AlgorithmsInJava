public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int t = 1<<n;
        for(int i = 0;i<t;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(((1<<j)&i )!= 0)
                    l.add(nums[j]);
            }
            res.add(l);
        }
        return res;
    }
}

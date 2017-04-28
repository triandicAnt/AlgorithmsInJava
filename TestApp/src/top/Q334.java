public class Q334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length==0)
            return false;
        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        for(int i : nums){
            if(i<=c1)
                c1 = i;
            else if(i<=c2)
                c2 = i;
            else
                return true;
        }
        return false;
    }
}

public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

      final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Long floor = values.floor(((long)nums[ind] + (long)t));
            final Long ceil = values.ceiling(((long)nums[ind] - (long)t));
            if ((floor != null && floor >= (long)nums[ind])
                    || (ceil != null && ceil <=  (long)nums[ind])) {
                return true;
            }

            values.add( (long)nums[ind]);
            if (ind >= k) {
                values.remove( (long)nums[ind - k]);
            }
        }
        return false;
    }

}

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = 0;
        for(int i = 1;i<=n;i++){
            x^=i;
        }
        int y = nums[0];
        for(int i = 1;i<n;i++){
            y^=nums[i];
        }
        return x^y;
    }
}

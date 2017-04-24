public class Q384 {
    int []nums;
    Random r;
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int [] a = new int[nums.length];
        System.arraycopy( this.nums, 0, a, 0, this.nums.length );
        for(int i =1;i<a.length;i++){
            int j = this.r.nextInt(i+1);
            swap(a,i,j);
        }
        return a;
    }
    public void swap(int []a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

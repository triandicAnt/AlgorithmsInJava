public class Q477 {
    public int totalHammingDistance(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        int total = 0;
       
        for(int i =0;i<32;i++){
             int countZero=0;
            int countOne = 0;
            int mask = 1<<i;
            for(int a :nums){
                if((mask&a) !=0)
                    countOne++;
                else
                    countZero++;
            }
            total += countZero*countOne;
        }
        return total;
    }
}

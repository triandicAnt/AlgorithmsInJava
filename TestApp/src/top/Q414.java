public class Q414 {
    public int thirdMax(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        // int num1 = Integer.MIN_VALUE;
        // int num2 = Integer.MIN_VALUE;
        // int num3 = Integer.MIN_VALUE;
        Integer num1 = null;
        Integer num2 = null;
        Integer num3 = null;
        
        for(Integer a : nums){
            if(a.equals(num1) || a.equals(num2) || a.equals(num3))
                continue;
            if(num1 == null || a>num1){
                num3 = num2;
                num2 = num1;
                num1 = a;
            }else if(num2 == null || a>num2){
                num3 = num2;
                num2 = a;
            }else if(num3==null || a>num3){
                num3 = a;
            }
            
        }
        return num3 == null?num1:num3;
        
    }
}

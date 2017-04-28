public class Q75 {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<2)
            return;
        int l = 0;
        int h = nums.length-1;
        int i = 0;
        for(i=l;i<=h;){
            if(nums[i] == 0){
                swap(nums,i,l);
                i++;
                l++;
            }else if(nums[i] == 2){
                swap(nums, i, h);
                h--;
            }else{
                i++;
            }
        }
    }
       public void swap(int []a, int l ,int h){
        int temp = a[l];
        a[l] = a[h];
        a[h] = temp;
    }
}

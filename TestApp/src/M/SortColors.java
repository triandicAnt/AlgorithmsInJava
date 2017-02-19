public class SortColors {
    public void sortColors(int[] nums) {
        if(nums==null | nums.length <2)
            return;
        int l = 0;
        int h = nums.length-1;
        for(int i = l ; i<=h;){
            if(nums[i]==0){
                swap(nums, l,i);
                l++;
                i++;
            }else if(nums[i]==2){
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

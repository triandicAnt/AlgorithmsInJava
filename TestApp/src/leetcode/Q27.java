public class Q27 {
    public int removeElement(int[] nums, int val) {
        return removeElements(nums,val);
    }
    public int remove(int [] nums, int val){
           if(nums==null||nums.length==0)
            return 0;
        int l = 0;
        int h = nums.length-1;
        int c = 0;
        for(int a : nums){
            if(a==val)
                c++;
        }
        while(h>=0 && nums[h]==val){
            h--;
        }
        if(l>h)
            return 0;
        while(l<h){
            if(nums[l] == val){
                //swap
                swap(nums,l,h);
                if(nums[l]!=val)
                    l++;
                if(nums[h]==val)
                    h--;
            }else{
                l++;
            }
        }
        if(h==nums.length-1)
            return nums.length;
        return nums.length-c;
    }
    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int removeElements(int [] a, int val){
        int n = a.length;
        int i = 0;
        while(i<n){
            if(a[i] == val){
                a[i] = a[n-1];
                n--;
            }else{
                i++;
            }
        }
        return i;
    }
}

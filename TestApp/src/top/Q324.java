public class Q324 {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int n = nums.length;
        int median = findKthLargest(nums, (n+1)/2);
        int l = 0;
        int h = n-1;
        int i = 0;
        while(i<=h){
            if(nums[newIndex(i,n)]>median){
                swap(nums, newIndex(i,n), newIndex(l,n));
                i++;
                l++;
            }else if(nums[newIndex(i,n)]<median){
                swap(nums, newIndex(i,n), newIndex(h,n));
                h--;
            }else{
                i++;
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
      if(nums==null || nums.length == 0 || nums.length<k)
        return 0;
      return findKthLargest(nums, 0, nums.length-1, k);
    }
    public int findKthLargest(int [] a, int l, int h, int k){
        if(l==h)
            return a[l];
        int p = getPartition(a, l, h);
        if(p==k-1)
            return a[p];
        else if(p>k-1)
            return findKthLargest(a,l, p, k);
        else
            return findKthLargest(a, p+1, h,k);
    }
    public int getPartition(int []a, int l, int h){
        if(l>=h)
            return l;
        int rand = getRandom(l,h);
        swap(a,l,rand);
        int p = a[l];
        int i = l+1;
        for(int j = l+1;j<=h;j++){
            if(a[j]>p){
                swap(a, i,j);
                i++;
            }
        }
        swap(a, l, i-1);
        return i-1;
    }
    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int getRandom(int l, int h){
        return new Random().nextInt(h-l+1)+l;
    }
    public int newIndex(int index, int n){
        return (2*index+1)%(n|1);
    }
}

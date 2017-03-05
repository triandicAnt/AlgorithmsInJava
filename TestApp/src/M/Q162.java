public class Q162 {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        if(nums.length==1)
            return 0;
        return findPeak(nums, 0, nums.length-1);
    }
    public int findPeak(int[]a, int l, int h){
        if(l>h)
            return -1;
        int mid = (l+h)/2;
        if((mid==0 && a[mid+1]<a[mid]) ||(mid == h && a[mid-1]<a[mid]))
            return mid;
        if((mid>0 && a[mid-1]<a[mid]) && (mid<h && a[mid+1]<a[mid])){
            return mid;
        }else if(mid>0 && a[mid-1]>a[mid])
            return findPeak(a,l, mid-1);
        return findPeak(a, mid+1, h);
    }
}

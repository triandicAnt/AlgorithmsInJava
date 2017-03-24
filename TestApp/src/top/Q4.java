public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2 == null)
            return 0.0;
        return median(nums1, nums2);
    }
    public double median(int []A, int B[]){
        int m = A.length;
        int n = B.length;
        if(m>n)
            return median(B,A);
        int i =0;
        int j = 0;
        int half = (m+n+1)/2;
        int low=0,high = m;
        while(low<=high){
            i = (low+high)/2;
            j = half - i;
            if(i>0 && A[i-1]>B[j]){
                high = i-1;
            }else if(i<m && A[i]<B[j-1]){
                low = i+1;
            }else{
                int left = 0;
                int right = 0;
                if(i==0)
                    left = B[j-1];
                else if(j==0)
                    left = A[i-1];
                else{
                    left = Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2==1)
                    return (double)left;
                if(i==m)
                    right = B[j];
                else if(j==n)   
                    right = A[i];
                else{
                    right = Math.min(A[i],B[j]);
                }
                return (double)(left+right)/2.0;
            }
        }
        return 0.0;
    }
}

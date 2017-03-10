public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return 0.0;
        return findMedian(nums1,nums2);
    }
    public double findMedian(int[] A, int []B){
        if(A.length>B.length)
            return findMedian(B,A);
        int m = A.length;
        int n = B.length;
        int l = 0;
        int h = m;
        int half = (m+n+1)/2;
        while(l<=h){
            int i = (l+h)/2;
            int j = half-i;
            if(i>0 && A[i-1]>B[j])
                h = i-1;
            else if(i<m && A[i] < B[j-1])
                l = i+1;
            else{
                int left = 0;
               // int lMax=0,y=0;
                if(i==0)
                    left= B[j-1];
               else if(j==0)
                    left=A[i-1];
               else
                left = Math.max(A[i-1], B[j-1]);
                if((m+n)%2==1)
                    return left;
                int right = 0;
                if(i==m)
                    right=B[j];
               else if(j==n)
                    right=A[i];
                else
                    right = Math.min(A[i],B[j]);
                return (left+right)/2.0;
            }
        }
        return -1;
    }
}

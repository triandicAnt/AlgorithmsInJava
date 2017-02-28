public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] A = nums1;
        int [] B = nums2;
        return findMedian(A,B);
    }
    public double findMedian(int[]A, int[]B){
        int m = A.length;
        int n = B.length;
        if(m>n)
            return findMedian(B,A);
        int min = 0;
        int max = m;
        int half = (m+n+1)/2;
        while(min<=max){
            int i = (min+max)/2;
            int j = half-i;
            if(i>0 && A[i-1]>B[j])
                max = i-1;
            else if(i<m && A[i]<B[j-1])
                min = i+1;
            else{
                int left = 0;
                int right = 0;
                if(i==0)
                    left = B[j-1];
                else if(j==0)
                    left = A[i-1];
                else 
                    left = Math.max(A[i-1], B[j-1]);
                if((m+n)%2==1)
                    return left;
                if(i==m)
                    right = B[j];
                else if(j==n)
                    right = A[i];
                else 
                    right = Math.min(A[i],B[j]);
                return (double)(left+right)/2.0;
            }
        }
        return 1.0;
    }
}

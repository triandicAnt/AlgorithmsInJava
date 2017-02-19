public class MediaOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null)
            return 0.0;
        else if(nums1==null)
            if(nums2.length%2==1)
                return (double)nums2[nums2.length/2];
            else
                return (double)(nums2[nums2.length/2] + nums2[nums2.length/2 +1])/2;
        else if(nums2==null)
            if(nums1.length%2==1)
                return (double)nums1[nums1.length/2];
            else
                return (double)(nums1[nums1.length/2] + nums1[nums1.length/2 +1])/2;
        else
            return findMedian(nums1,nums2);
    }
    public double findMedian(int A[], int B[]){
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
                int leftMax = 0;
                int rightMax = 0;
                if(i==0)
                    leftMax = B[j-1];
                else if(j==0)
                    leftMax = A[i-1];
                else{
                    leftMax = Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2==1)
                    return (double)leftMax;
                if(i==m)
                    rightMax = B[j];
                else if(j==n)
                    rightMax = A[i];
                else
                    rightMax = Math.min(A[i],B[j]);
                return (double)(leftMax + rightMax)/2.0;
            }
        }
        return 0.0;
    }
}

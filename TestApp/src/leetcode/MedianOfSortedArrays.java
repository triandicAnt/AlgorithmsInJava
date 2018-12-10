package leetcode;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * nums1 = [1, 3]
			nums2 = [2]

			The median is 2.0
		 */
		int [] a1 = {1,3};
		int [] a2 = {2}; 
		System.out.println(findMedian(a1, a2));
		System.out.println("-----");
		
		int []a3 = {1,2};
		int []a4 = {3,4};
		System.out.println(findMedian(a3, a4));
		
		int []a5 = {1,2,5};
		int []a6 = {3,4,6};
		System.out.println(findMedian(a5, a6));

	}
/**
 * Find Kth element in the array where K is defined as (len(a1)+len(a2))/2
 * 
 */
	public static double findMedian(int []a1, int[] a2){
		int n = a1.length+a2.length;
		// if n is even then return avg of (n/2 + 1 and n/2)
		// else return n/2
		if(n%2 ==0){
			return (findKth(n/2 +1, a1,a2,0,0) + findKth(n/2, a1,a2,0,0))/2.0;
		}else{
			return findKth(n/2  +1, a1,a2,0,0);
		}
	}
	
	/**
	 * find Kth element
	 */
	public static int findKth(int k, int []a1, int []a2, int i, int j){
		if(i>=a1.length)
			return a2[j+k-1];
		if(j>=a2.length)
			return a1[i+k-1];
		if(k==1)
			return Math.min(a1[i], a2[j]);
		int m1 = i+k/2-1;
		int m2 = j+k/2-1;
		
		int mid1 = m1<a1.length?a1[m1]:Integer.MAX_VALUE;
		int mid2 = m2<a2.length?a2[m2]:Integer.MAX_VALUE;
		
		if(mid1<mid2)
			return findKth(k-k/2, a1, a2, m1+1, j);
		else
			return findKth(k-k/2, a1, a2, i, m2+1);
	}
	
	/*
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if (x > y)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = x;
        while(low <= high) {
            int partX = (low + high)/2;
            int partY = (x+y+1)/2 - partX;
            int minLeftX = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            int maxRightX = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int minLeftY = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            int maxRightY = partY == y ? Integer.MAX_VALUE : nums2[partY];
            if (minLeftX <= maxRightY && minLeftY <= maxRightX) {
                // if even and avg
                if ((x+y)%2 == 0) {
                    return (double) (Math.max(minLeftX, minLeftY) + Math.min(maxRightX, maxRightY))/2.0;
                } else {
                    return (double)Math.max(minLeftX, minLeftY);
                }
            } else if (minLeftX > maxRightY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return -1.0;
    }
*/
}

/**
 * Ref : http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 * Time limit exceeded
 */

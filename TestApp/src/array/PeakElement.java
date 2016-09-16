package array;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {5,10,15,25,30,45,65,50,35,23};
		System.out.println(findPeakElement(arr, 0, arr.length-1));
		int arr2[] = {1, 3, 20, 4, 1, 0};
		System.out.println(findPeakElement(arr2, 0, arr2.length));
	}
	
	/**
	 * Find peak element of an array using binary search
	 */
	
	static int findPeakElement(int [] arr, int start, int end){
		if(start>end){
			return -1;
		}
		int mid = (start+end)/2;
		
		if(arr[mid-1] <= arr[mid] && arr[mid]>= arr[mid+1]){
			return arr[mid];
		}
		// check if the left of mid is greater than min
		if(arr[mid-1]>arr[mid])
			return findPeakElement(arr, start, mid-1);
		else if (arr[mid+1]>arr[mid])
			return findPeakElement(arr, mid+1, end);
		return -1;
				
	}

}

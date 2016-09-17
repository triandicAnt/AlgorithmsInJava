package array;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,2,1,5,6,7,8};
		System.out.println("1 " + (searchInRotated(arr, 1, 0, 7) == 3));
		System.out.println("3 " + (searchInRotated(arr, 3, 0, 7) == 1));
		System.out.println("6 "+(searchInRotated(arr, 6, 0, 7) == 5));
		System.out.println("4 "+(searchInRotated(arr, 4, 0, 7) == 0));
		System.out.println(searchInRotated(arr, 2, 0, 7) == 2);
		System.out.println(searchInRotated(arr, 5, 0, 7) == 4);
		System.out.println(searchInRotated(arr, 7, 0, 7) == 6);
		System.out.println(searchInRotated(arr, 8, 0, 7) == 7);

	}
	
	/**
	 * [4,3,2,1,5,6,7,8]
	 */
	
	static int searchInRotated(int [] arr,int x, int start, int end){
		if(start>end)
			return -1;
		int mid = start + (end-start)/2;
		// check whether the middle element is x 
//		System.out.println("--" + mid);
		if(arr[mid] == x)
			return mid;
		if(arr[start] > arr[mid]){
			// right half is sorted
			if(x >= arr[mid+1] && x<= arr[end])
				// search in right part
				return searchInRotated(arr, x, mid+1, end);
			else
				return searchInRotated(arr, x, start, mid-1);
		}
		
		else if(arr[start]< arr[mid]){
			// left side is sorted
			if(x>=arr[start] && x <= arr[mid-1])
				return searchInRotated(arr, x, start, mid-1);
			else
				return searchInRotated(arr, x, mid+1, end);
		}// else left to mid have same element ... search both side
		else if(arr[start] == arr[mid]){
			if(arr[mid]!=arr[end])
				//search right side
				return searchInRotated(arr, x, mid+1, end);
			else{
				// search both side
				int result = searchInRotated(arr, x, start, mid-1);
				if(result == -1)
					result = searchInRotated(arr, x, mid+1, end);
				return result;
			}
		}
		return -1;
	}
}

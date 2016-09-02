package random;

public class RecursionProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {};
		System.out.println(arr_mul(a, 0, 1));

	}


	static boolean arr_mul( int arr[], int n, int sum )
	{ // must be recursive

	    if (n <= 0) {
	         return false;
	    } else {
	         sum *= arr[n];
	         if (sum ==0) return true;
	    }

	    return arr_mul(arr, --n, sum);
	}
}

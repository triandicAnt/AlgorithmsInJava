package bits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countBits(2));
		System.out.println(countBits(7));
		System.out.println(countBits(10));
		int arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
		System.out.println(sortArray(arr));
		int arr1[] = {1, 2, 3, 4, 5, 6};
		System.out.println(sortArray(arr1));
	}
	/**
	 * Input: arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
		Output: 15 7 5 3 9 6 2 4 32
		Input: arr[] = {1, 2, 3, 4, 5, 6};
		Output: 3 5 6 1 2 4
	 * @param num
	 * @return
	 */
	//2 - 10
	// 3 - 11
	static int countBits(int num){
		int count = 0;
		while(num>0){
			if((num & 1)>0){
				count ++;
			}
			num = num>>1;
		}
		return count;
	}
	
	public static Comparator<Integer> compareNumber(){
		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2){
				if(countBits(i1)>countBits(i2))
					return -1;
				else if(countBits(i1)<countBits(i2))
					return 1;
				else 
					return 0;		
			}
		};
		return comp;
	}
	static ArrayList<Integer> sortArray(int [] arr){
		
		ArrayList<Integer> aL = new ArrayList<Integer>();
		for(int a:arr){
			aL.add(a);
		}
		Collections.sort(aL, compareNumber());
		return  aL;
	}

}
//aaabc
//a=3
//b=1
//c11
//(n/2)

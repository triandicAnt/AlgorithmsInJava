package random;

import java.util.Arrays;

public class FindOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ones(3) == "111".length());
//		System.out.println(ones(13) == "111111".length());
//		System.out.println(ones(23) == "1111111111111111111111".length());
		int arr[] = {2, 7, 7, 5, 3, 4, 1, 7};
//		System.out.println(maxRepeatingNumber(arr, 8));
		int [] a = {1,2,3,4};
		System.out.println(Arrays.toString(swapWithLimit(a, 2)));
		//System.out.println(a[1,3]);

	}
	//http://stackoverflow.com/questions/7129855/algorithm-in-c-playing-with-numbers-number-with-3-in-units-place/7130063#7130063
	static int ones(int n){
		int m=1;
		for(int i =1; i<=n;i++){
			if(m==0)
				return i;
			m = (10*m+1)%n;
		}
		return -1;
	}
	// Maximum repeating number
	
	static int maxRepeatingNumber(int [] a, int k){
		int n = a.length;
		for(int i=0;i<a.length;i++){
			a[a[i]%k] += k;
		}
		int max = a[0];
		int index = 0;
		for(int i=0;i<n;i++){
			if(a[i]>max){
				max = a[i];
				index = i;
			}
		}
		for(int i=0;i<n;i++){
			a[i] = a[i]%k;
		}
		return index;
	}
	// https://www.careercup.com/question?id=5638261762424832
	/*static int [] maximize(int []a, int s){
		int n = a.length-1;
		for(int j=0; j<n;j++){
			int i = maxDigit(a, j, n);
			if(s<n-j){
				i=s;
			}
			for(; i>j;i--){
				swap(a,i,i-1);
			}
		}
		return a;
	}
		static int maxDigit(int[] a, int s, int e){
			int max = a[s];
			int maxIndex = s;
			for(int i = s;i<=e;i++){
				if(max<a[i]){
					max = a[i];
					maxIndex = i;
				}
			}
			return maxIndex;
		}
	
	public static int[] maximize(int[] ar, int swapsAllowed){
		int numSwaps=swapsAllowed;
		
		for(int j=0;j<ar.length-1 && numSwaps!=0; j++){
			int i=maxNum(ar, j, ar.length-1);
			if(numSwaps<ar.length-j)
				i=numSwaps;
			for(; i>j;i--){
			swap(ar,i,i-1);
			numSwaps--;
		}
		}
		return ar;
	}*/
	public static int[] swapWithLimit (int[] array, int limit){
        int limitLeft = limit;
        for (int j = 0; (j < array.length) && (limitLeft > 0); j++){
            int maxIndx = j;                                                    
            for (int i = j + 1; i < array.length; i++){            
                if ( (array[maxIndx] < array[i]) && ((i - j) <= limit)){
                    maxIndx = i;                                                
                }
            }
            
            if (maxIndx != j){
                int temp = array[j];
                array[j] = array[maxIndx];
                array[maxIndx] = temp;
                
                limitLeft = limit - maxIndx;
                
            }
        }
        return array;
        
    }
		static void swap(int []a, int i, int j){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
}

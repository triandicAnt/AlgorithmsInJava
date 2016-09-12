/**
 * 
 */
package array;

import java.util.Random;

/**
 * @author Sudhansu
 *
 */
public class SelectAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SelectAlgorithm s = new SelectAlgorithm();
		int []a = new int [] {3,4,2,1,6,9,8,11};
		System.out.println(s.selectIthSmallest(a, 0, a.length-1, 5));
		System.out.println(s.selectIthLargest(a, 0, a.length-1, 8));

	}
	/**
	 * Select the ith smallest element in the array
	 * @param a
	 * @param p
	 * @param r
	 * @param i
	 * @return
	 */
	int selectIthSmallest(int []a, int p, int r, int i){
		if(p==r)
			return a[p];
		else{
			int q = randomPartition(a, p, r);
			int k = q-p+1;
			if(k==i)
				return a[q];
			else if(k>i){
				return selectIthSmallest(a, p, q-1, i);
			}
			else
				return selectIthSmallest(a, q+1, r, i-k);
		}
	}
	
	/**
	 * Select ith largest element in the array
	 * @param a
	 * @param p
	 * @param r
	 * @param i
	 * @return
	 */
	
	int selectIthLargest(int []a, int p, int r, int i){
		return selectIthSmallest(a, p, r, a.length-i+1);
	}
	/**
	 * Generate a random partition element in the array
	 * @param array
	 * @param l
	 * @param r
	 * @return
	 */
	int randomPartition(int array[], int l, int r){
		// generate a random number between l and r
		int random = randInt(l, r);
		swap(array, l, random);
		int p = array[l];
		int i = l+1;
		for (int j = l+1; j <= r; j++) {
			if(array[j]<p){
				swap(array,i,j);
				i=i+1;
			}
		}
		swap(array,i-1,l);
		return i-1;
	}
	/**
	 * Swap two index elements in the array a
	 * @param a
	 * @param i
	 * @param j
	 */
	void swap(int [] a,int i, int j ){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * Generate a random element in the range min - max
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
/**
/**
def  melon_count(boxes, melons):
#print boxes
#print melons
x = 0
i = 0
j = 0
max = 0
c = 0

for x in range(0,len(melons)):
    i = x
    j = 0
    c = 0
    while(i<len(melons) and j< len(boxes)):
        if melons[i]<= boxes[j]:
            c = c+1
            i = i+1
            j += 1
        else:
            j = j+1
    if c > max:
        max = c
return max

**/
/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] arr = new int [num + 1];
        for(int i =0; i<=num;i++){
            arr[i] = numberOfOnes(i);
        }
        return arr;
    }
    public int numberOfOnes(int n){
        int c =0;
        while(n>0){
            if((n&1)==1){
                c++;
            }
            n = n>>1;
        }
        return c;
    }
}
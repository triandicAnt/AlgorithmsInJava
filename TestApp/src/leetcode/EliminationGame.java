/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/elimination-game/
 */
public class EliminationGame {

    public int lastRemaining(int n) {
       /* boolean [] arr = new boolean[n];
        Arrays.fill(arr,true);
        boolean flag = true;
        boolean breakFlag = false;
        int count = 0;
        int ans = 0;
        while(!breakFlag){
            if(flag){
                int index = findStart(arr,flag);
                 for(int i=index; i<n;i+=2){
                    arr[i] = false;
                    count++;
                    ans = i;
                }
                if(count<=2){
                    breakFlag = true;
                    break;
                }
                count = 0;
            }else{
                 int index = findStart(arr,!flag);
                 for(int i=index; i>=0;i-=2){
                    arr[i] = false;
                    count++;
                    ans = i;
                }
                if(count<=2){
                    breakFlag = true;
                    break;
                }
                count = 0;
            }
        }
        return ans+1;
        */
        return findIndex(n,true);

    }
    
    public int findIndex(int n, boolean flag){
        if(n==1)
            return 1;
        if(flag){
            return 2*findIndex(n/2, false);
        }else{
            return 2*findIndex(n/2,true) -1 + n%2;
        }
    }
    
    public int findStart(boolean [] arr, boolean flag){
        int index = 0;
        if(flag){
            for(int i=0;i<arr.length;i++){
                if(arr[i]==true){
                    index = i;
                    break;
                }
            }
        }else{
              for(int i=arr.length-1;i>=0;i--){
                if(arr[i]==true){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
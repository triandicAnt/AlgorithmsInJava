package leetcode;


public class Q276{
public static int paintFence(int n , int k){
        if(n==0)
            return 0;
        if(n==1)
            return k;
        int sameColor = k;
        int differentColor = k*(k-1);
        for(int i=2;i<n;i++){
            int temp = differentColor;
            differentColor = (differentColor+sameColor)*(k-1);
            sameColor = temp;
        }
        return differentColor+sameColor;
    }
 }

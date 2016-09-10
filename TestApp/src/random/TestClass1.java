package random;


import java.io.*;
import java.util.Scanner;
public class TestClass1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        int []  arr = new int[i];
        int j = scan.nextInt();
        for(int k = 0; k<j;j++){
            int bi = scan.nextInt();
            int ei = scan.nextInt();
            int num = scan.nextInt();
            for(int p = bi-1; p<=ei-1;p++){
                arr[p]+=num;
            }
            //System.out.println(bi +" " +ei+ " "+ num );
        }
        scan.close();
        int max = Integer.MIN_VALUE;
        for(int x:arr){
            if(x>max)
                max = x;
        }
        System.out.println(max);
    }
}
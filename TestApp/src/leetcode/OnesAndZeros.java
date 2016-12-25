package leetcode;

import java.util.Arrays;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
    //  Arrays.sort(strs,new Comparator<String>()
    // {
    //   public int compare(String s1,String s2)
    //   {
    //     return s1.length() - s2.length();
    //     }
    // });
    int    temp [][] = new int [m+1][n+1];
     System.out.println(Arrays.toString(strs));
     int count = 0;
     for(String s:strs){
         int zeros = 0;
         int ones = 0;
         for(char c:s.toCharArray()){
             if(c=='0')
                zeros++;
            else
                ones++;
         }
        //  m-=zeros;
        //  n-=ones;
        //  if(m<0||n<0){
        //     break;
        //  }
        // count++;
        for(int i=m;i>zeros-1;i--){
            for(int j=n;j>ones-1;j--){
                temp[i][j] = Math.max(temp[i][j],temp[i-zeros][j-ones]+1);
            }
        }
        System.out.println(Arrays.deepToString(temp));
     }
     return temp[m][n];
    }
}

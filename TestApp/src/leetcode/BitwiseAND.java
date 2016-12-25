package leetcode;

public class BitwiseAND {
    public int rangeBitwiseAnd(int m, int n) {
       /*  int x =m;
        for(int i=m+1;i<=n;i++){
            if(x==0)
                break;
            x=x&i;
            //System.out.println(x);
        }
        return x; */
        
        int x = 0;
        while(m!=n){
            m = m>>1;
            n= n>>1;
            x+=1;
        }
        return m<<x;
    }
}

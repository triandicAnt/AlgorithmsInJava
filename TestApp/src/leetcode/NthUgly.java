public class NthUgly {
    public int nthUglyNumber(int n) {
        int u = 1;
        int [] ugly = new int [n];
       
        int i=0,j=0,k=0;
        ugly[0] = 1;
        for(int x=1;x<n;x++){
            int min = Math.min(Math.min(2*ugly[i],3*ugly[j]),5*ugly[k]);
            
            if(min == 2*ugly[i])
                i++;
            if(min == 3*ugly[j])
                j++;
            if(min == 5*ugly[k])
                k++;
            ugly[x] = min;
        }
        System.out.println(Arrays.toString(ugly));
        return ugly[n-1];
    }
}

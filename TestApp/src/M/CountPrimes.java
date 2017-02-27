public class CountPrimes {
    public int countPrimes(int n) {
        if(n==0 || n==1)
            return 0;
        boolean []temp = new boolean[n];
        for(int i =2;i<n;i++)
            temp[i] = true;
        for(int i =2;i*i<n;i++){
            if(!temp[i])
                continue;
            for(int j = i*i;j<n;j+=i){
                temp[j] = false;
            }
        }
    
        int count = 0;
        for(int i =2;i<n;i++){
            if(temp[i])
                count++;
        }
        return count;
    }
}

public class KthLarget {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(k>n)
            return -1;
        return getIthSmallest(nums,0,n-1,n-k+1);
    }
    
    public int getIthSmallest(int a[], int l, int r,int k){
        int p = getPartition(a,l,r);
        int q = p-l+1;
        if(q==k)
            return a[p];
        else if(q>k)
            return getIthSmallest(a,l,p-1,k);
        else
            return getIthSmallest(a,p+1,r,k-q);
    }
    
    public int getPartition(int []a, int l, int r){
        int random = getRandom(l,r);
        swap(a,l,random);
        int p = a[l];
        int i = l+1;
        for(int j = l+1;j<=r;j++){
            if(a[j]<p){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i-1,l);
        return i-1;
    }
    
    public void swap(int [] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
    
    public int getRandom(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }
}

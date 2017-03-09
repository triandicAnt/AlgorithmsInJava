public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return -1;
        return kthSmallest(nums,0,nums.length-1, k);
    }
   /* public int kthSmallest(int [] a,int l, int r, int k){
        if(l==r)
            return a[l];
        int p = getPartition(a,l,r);
        int q = p-l+1;
        if(q==k)
            return a[p];
        else if(k>q)
            return kthSmallest(a,p+1,r,k-q);
        else
            return kthSmallest(a,l,p-1,k);
    }*/
     public int kthSmallest(int [] a,int l, int r, int k){
        if(l==r)
            return a[l];
        int p = getPartition(a,l,r);
       // int q = p-l+1;
        if(p==k-1)
            return a[p];
        else if(p>k-1)
            return kthSmallest(a,l,p,k);
        else
            return kthSmallest(a,p+1,r,k);
    }
    
    public int getPartition(int a[] , int l, int r){
        if(l>=r)
            return l;
        int rand = getRandom(l,r);
        swap(a,l,rand);
        int p = a[l];
        int i = l+1;
        for(int j = l+1;j<=r;j++){
            if(a[j]>p){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i-1,l);
        return i-1;
        
    }
    
    public int getRandom(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }
    
    public void swap(int [] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int a : nums){
            pq.offer(a);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
        
    }
       public int findKthLargest(int[] nums, int k) {
        return getIthSmallest(nums,0,nums.length-1,nums.length-k+1);
    }
    
    
    public int getIthSmallest(int []A, int p, int r, int i){
        if(p==r)
            return A[p];
        int q = getPartition(A,p,r);
        int k = q-p+1;
        if(k==i)
            return A[q];
        else if(k>i)
            return getIthSmallest(A,p,q-1,i);
        else
            return getIthSmallest(A,q+1,r,i-k);
    }
    
    // helper function
    public int getPartition(int A[], int l, int r){
        if(l>=r)
            return l;
        int random = getRandom(l,r);
        swap(A,l,random);
        int p = A[l];
        int i = l+1;
        for(int j=l+1;j<=r;j++){
            if(A[j]<p){
                swap(A,i,j);
                i+=1;
            }
        }
        swap(A,i-1,l);
        return i-1;
    }
    
    
    public void swap(int []A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public int getRandom(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }
}

public class Q307{

}
class NumArray {
    int [] segArray;
    int [] lazy;
    int n;
    int [] nums;
    public NumArray(int[] nums) {
        int l = nums.length;
        if(l==0)
            return;
        this.n = l;
        this.nums = nums;
        int len = 2*getNextPowOf2(l) -1;
        this.segArray = new int [len];
        this.lazy = new int [len];
        buildTree(nums,0,l-1,0);
    }
    
    public void buildTree(int [] nums, int low, int high, int pos){
        if(low == high){
            this.segArray[pos] = nums[low];
            return ;
        }
        int mid = low + (high-low)/2;
        buildTree(nums, low, mid, 2*pos+1);
        buildTree(nums, mid+1, high, 2*pos+2);
        this.segArray[pos] = this.segArray[2*pos+1] + this.segArray[2*pos+2];
    }

    void update(int i, int val) {
        int diff =  val - this.nums[i];
        this.nums[i] = val;
        update(i,i,0,this.n-1,0, diff);
    }
    void update(int qLow, int qHigh, int low, int high , int pos, int delta){
        if(low>high)
            return;
        // propagate the lazy value 
        if(lazy[pos]!=0){
            this.segArray[pos] += lazy[pos];
            // if not a leaf node
            if(low!=high){
                lazy[2*pos+1] += this.lazy[pos];
                lazy[2*pos+2] += this.lazy[pos];
            }
            lazy[pos] = 0;
        }
        
        // no overlap
        if(qLow>high || qHigh <low)
            return;
            
        // fully overlap
        if(qLow<= low && qHigh >= high){
            // update segArray value
            this.segArray[pos] += delta;
            // if not a leaf node
            if(low !=high){
                this.lazy[2*pos + 1] += delta;
                this.lazy[2*pos +2] += delta;
            }
            return;
        }
        
        // partially overlap
        int mid = low + (high-low)/2;
        update(qLow, qHigh, low, mid, 2*pos+1,delta);
        update(qLow, qHigh, mid+1, high, 2*pos+2,delta);
        this.segArray[pos] = this.segArray[2*pos+1] + this.segArray[2*pos+2];
    }

    public int sumRange(int i, int j) {
        return sumRange(i,j,0,this.n-1,0);
    }
    public int sumRange(int qLow, int qHigh, int low, int high, int pos){
        // total overlap
        if(qLow<= low && qHigh >= high)
            return this.segArray[pos];
        // no overlap
        if(qLow> high || qHigh < low)
            return 0;
        // partially overlap
        int mid = low + (high - low)/2;
        return sumRange(qLow, qHigh, low, mid, 2*pos+1) +
                sumRange(qLow, qHigh, mid+1,high, 2*pos+2);
    }
    
    public int getNextPowOf2(int n){
        if(n==0)
            return 1;
        if((n&(n-1))==0)
            return n;
        while((n&(n-1)) == 0){
            n = (n&(n-1));
        }
        return n<<1;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

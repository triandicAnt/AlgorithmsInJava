 class NumArray {
    int [] segArray ;
    int n ;
    public NumArray(int[] nums) {
        this.segArray = new int[2*getNextPowOf2(nums.length)-1];
        this.n = nums.length;
        if(this.n>0)
            buildTree(nums,this.segArray,0,nums.length-1,0);
    }
    public void buildTree(int[] nums, int []segArray, int l,int h, int p){
        if(l==h){
            segArray[p] = nums[l];
            return;
        }
        int m = l+(h-l)/2;
        buildTree(nums,segArray,l,m,2*p+1);
        buildTree(nums,segArray,m+1,h,2*p+2);
        segArray[p] = segArray[2*p+1] + segArray[2*p+2];
    }

    public int sumRange(int i, int j) {
        return sumRange(i,j,0,n-1,0);
    }
    public int sumRange(int qLow, int qHigh, int low, int high, int pos){
        // fully overlap
        if(qLow<=low && qHigh>=high)
            return this.segArray[pos];
        if(qLow>high || qHigh<low)
            return 0;
        int mid = low + (high-low)/2;
        return sumRange(qLow,qHigh,low,mid,2*pos+1) +
                sumRange(qLow,qHigh, mid+1,high, 2*pos+2);
    }
    
    public int getNextPowOf2(int n){
        if(n==0)
            return 1;
        if((n&(n-1))==0)
            return n;
        while((n&(n-1))>0){
            n = (n&(n-1));
        }
        return n<<1;
    }
}
public class Q303{

}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

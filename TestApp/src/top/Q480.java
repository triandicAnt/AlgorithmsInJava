public class Q480 {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length==0 || nums.length<k)
            return new double[0];
        
        int n = nums.length-k+1;
        double res[] = new double[n];
        for(int i =0;i<=nums.length;i++){
            if(i>=k){
                res[i-k] = getMedian();
                remove(nums[i-k]);
            }
            if(i<nums.length)
                add(nums[i]);
        }
        return res;
    }
    public void add(int num){
        (num<getMedian()?maxHeap:minHeap).offer(num);
        resizeHeap();
    }
    public void remove(int num){
        (num<getMedian()?maxHeap:minHeap).remove(num);
        resizeHeap();
    }
    public void resizeHeap(){
        if(maxHeap.size()>minHeap.size())
            minHeap.offer(maxHeap.remove());
        else if(minHeap.size()-maxHeap.size()>1)
            maxHeap.offer(minHeap.remove());
    }
    public double getMedian(){
        if(maxHeap.isEmpty() && minHeap.isEmpty())
            return 0;
        else if(maxHeap.size()==minHeap.size())
            return ((double)maxHeap.peek()+(double)minHeap.peek())/2.0;
        else
            return (double)minHeap.peek();
    }
}

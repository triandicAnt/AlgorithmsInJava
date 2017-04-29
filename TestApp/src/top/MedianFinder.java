public class MedianFinder {
    Queue<Long> minHeap;
    Queue<Long> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.offer((long)num);
            return;
        }
        // if(minHeap.size()==0){
        //     minHeap.offer((long)num);
        //     return;
        // }
        if(maxHeap.peek()<=(long)num){
            minHeap.offer((long)num);
        }else{
            maxHeap.offer((long)num);
        }
        if(maxHeap.size()-minHeap.size()>1)
            minHeap.offer(maxHeap.remove());
        else if(minHeap.size()-maxHeap.size()>1)
            maxHeap.offer(minHeap.remove());
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
            return (maxHeap.peek()+minHeap.peek())/2.0;
        else if(maxHeap.size()>minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

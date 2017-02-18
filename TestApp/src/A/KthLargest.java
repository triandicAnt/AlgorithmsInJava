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
}

public class Q414 {
    public int thirdMax(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums){
            if(set.add(a)){
                pq.offer(a);
                if(pq.size()>3)
                    pq.poll();
            }
        }
        if(pq.size()==2)
            pq.poll();
        return pq.peek();
    }
}

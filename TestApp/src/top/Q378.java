public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length == 0)
            return -1;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int n = matrix.length;
        for(int i = 0; i<n;i++)
            pq.offer(new Tuple(0,i,matrix[0][i]));
        for(int i = 0; i<k-1;i++){
            Tuple t = pq.poll();
            if(t.x == n-1)
                continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}
class Tuple implements Comparable<Tuple>{
    int x;
    int y;
    int val;
    Tuple(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple o){
        return this.val - o.val;
    }
}

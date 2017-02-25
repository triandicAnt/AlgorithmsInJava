public class Q218 {
    public List<int[]> getSkyline(int[][] buildings) {
        //System.out.println(Arrays.deepToStirng(buildings));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        Point[] list = new Point[2*buildings.length];
        for(int [] b : buildings){
            list[i] = new Point(b[0],b[2],true);
            list[i+1] = new Point(b[1],b[2],false);
            i+=2;
        }
        Arrays.sort(list);
        List<int[]> res = new ArrayList<>();
       // System.out.println(Arrays.toString(list));
        int max = 0;
        q.offer(0);
        for(Point p : list){
            int[] a = new int [2];
            if(p.isStart){
                q.offer(p.height);
                if(q.peek()!=max){
                    a[0] = p.x;
                    a[1] = p.height;
                    max = q.peek();
                    res.add(a);
                }
            }else{
                q.remove(p.height);
                if(q.size()>0 && max!=q.peek()){
                    a[0] = p.x;
                    a[1] = q.peek();
                    res.add(a);
                    max = q.peek();
                }
            }
        }
        
        return res;
        
    }
}
class Point implements Comparable<Point>{
    int x;
    int height;
    boolean isStart;
    
    public Point(int x, int h, boolean f){
        this.x = x;
        this.height = h;
        this.isStart = f;
    }
    
    public int compareTo(Point o){
        if(this.x!=o.x)
            return this.x-o.x;
        else{
            return (this.isStart?-this.height:this.height) - (o.isStart?-o.height:o.height);
        }
    }
    public String toString(){
        return this.x + " " + this.height + " " + this.isStart;
    }
}

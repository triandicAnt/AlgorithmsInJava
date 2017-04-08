public class Q218 {
 public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> list = new ArrayList<>();
     if(buildings == null || buildings.length == 0)
        return list;
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     pq.offer(0);
     
     Point[] p = new Point[2*buildings.length];
     int i =0;
     for(int b[] : buildings){
       p[i] = new Point(b[0], b[2], true);
       p[i+1] = new Point(b[1], b[2], false);
       i+=2;  
     }

     Arrays.sort(p);
     int max = 0;
     for(Point pt: p){
      if(pt.isStart){
        pq.offer(pt.h);
        if(max!=pq.peek()){
          list.add(new int[]{pt.x, pt.h});
          max = pq.peek();
        }
          
      }else{
          pq.remove(pt.h);
          if(pq.size()>0 && max!=pq.peek()){
            list.add(new int []{pt.x, pq.peek()});
            max = pq.peek();
          }
        }
     }
         return list;

   }
}

class Point implements Comparable<Point>{
  int x;
  int h;
  boolean isStart;
  public Point(int x, int h, boolean s){
   this.x = x;
   this.h= h;
    this.isStart = s;
  }
  public int compareTo(Point o){
    if(this.x!=o.x)
        return this.x-o.x;
    return (this.isStart?-this.h:this.h)-(o.isStart?-o.h:o.h);
  }
}

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Q149 {
    public int maxPoints(Point[] points) {
        if(points==null)
            return 0;
        if(points.length<=2)
            return points.length;
        int result = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i =0;i<points.length;i++){
            map.clear();
            int same = 0;
            int max = 0;
            for(int j=i+1;j<points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x==0 && y==0){
                    same++;
                    continue;
                }
                int g = gcd(x,y);
                if(g!=0){
                    x/=g;
                    y/=g;
                }
                if(map.containsKey(x)){
                    if(map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y,1);
                    map.put(x,m);
                }
                max = Math.max(max,map.get(x).get(y));
            }
            result = Math.max(result, max+same+1);
        }
        return result;
    }
    public int gcd(int x, int y){
        if(y==0)
            return x;
        return gcd(y, x%y);
    }
}

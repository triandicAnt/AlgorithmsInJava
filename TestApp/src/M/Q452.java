public class Q452 {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0)
            return 0;
        Arrays.sort(points, Comparator.comparingInt(p->p[1]));
        long max = 0;
        long l = Long.MIN_VALUE;
        for(int []p: points){
            if(l<p[0]){
                l = p[1];
                max++;
            }
        }
        return (int)max;
    }
}

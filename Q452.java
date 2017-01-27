public class Q452 {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0)
            return 0;
        Arrays.sort(points,new Comparator<int []>(){
            public int compare(int[]i1, int []i2){
                return Integer.compare(i1[1],i2[1]);
            }
        });
        int count = 1;
        int value = points[0][1];
        for(int [] a: points){
            if(a[0]>value){
                count ++;
                value = a[1];
            }else{
                continue;
            }
        }
        return count;
    }
}

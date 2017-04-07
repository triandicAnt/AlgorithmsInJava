/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Q435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        
        if(intervals==null || intervals.length==0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1 , Interval i2){
                    return i1.end-i2.end;
            }
        });
        int count = 1;
        int end = intervals[0].end;
        for(int i=1; i<intervals.length;i++){
            
            if(intervals[i].start>=end){
                count++;
                end = intervals[i].end;
            }
                
        }
        return intervals.length-count;
    }
}

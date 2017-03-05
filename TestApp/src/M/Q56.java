/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Q56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals==null || intervals.size()==0)
            return list;
        Collections.sort(intervals,new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               return i1.start-i2.start;
           } 
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval i : intervals){
            if(end>=i.start){
                end = Math.max(end,i.end);
            }else{
                list.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        list.add(new Interval(start,end));
        return list;
    }
}

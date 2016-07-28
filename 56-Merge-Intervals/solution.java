/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null)
            return res;
        Collections.sort(intervals, intervalComparator);
        Interval last = intervals.get(0);
        for(int i=1; i<intervals.size(); i++)
        {
            Interval cur = intervals.get(i);
            if(cur.start<=last.end)
            {
                last.end = Math.max(last.end, cur.end);
            }
            else{
                res.add(last);
                last = cur;
            }
        }
        res.add(last);
        return res;
    }
    Comparator<Interval> intervalComparator = new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    };
}
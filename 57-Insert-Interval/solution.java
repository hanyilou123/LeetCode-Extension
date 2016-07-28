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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null)
            return res;
        if(newInterval==null)
            return intervals;
        int insertPos = 0;
        for(Interval interval : intervals)
        {
            if(interval.end < newInterval.start)
            {
                res.add(interval);
                insertPos++;
            }
            else if(interval.start > newInterval.end)
            {
                res.add(interval);
            }
            else
            {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        res.add(insertPos, newInterval);
        return res;
    }
}
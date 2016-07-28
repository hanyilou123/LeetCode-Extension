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
        for(int i=0; i<intervals.size(); i++)
        {
            if(intervals.get(i).end < newInterval.start)
            {
                res.add(intervals.get(i));
                insertPos++;
            }
            else if(intervals.get(i).start > newInterval.end)
            {
                res.add(intervals.get(i));
            }
            else
            {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        res.add(insertPos, newInterval);
        return res;
    }
}
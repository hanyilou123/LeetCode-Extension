/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> tm;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        tm = new TreeMap<Integer, Interval>();
    }
    
    public void addNum(int val) {
        if(tm.containsKey(val))
            return;
        Integer l = tm.lowerKey(val);
        Integer h = tm.higherKey(val);
        if(l!=null && tm.get(l).end+1==val && h!=null && val+1==h)
        {
            tm.get(l).end = tm.get(h).end;
            tm.remove(h);
        }
        else if(l!=null && tm.get(l).end+1>=val)
        {
            tm.get(l).end = Math.max(tm.get(l).end, val);
        }
        else if(h!=null && h==val+1)
        {
            tm.put(val, new Interval(val, tm.get(h).end));
            tm.remove(h);
        }
        else
        {
            tm.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(tm.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
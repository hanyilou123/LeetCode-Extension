public class Solution {
    // http://www.cnblogs.com/grandyang/p/5216856.html
    public boolean isSelfCrossing(int[] x) {
        if(x.length<=3)
            return false;
        for(int i=3; i<x.length; i++)
        {
            if(x[i]>=x[i-2] && x[i-1]<=x[i-3])
                return true;
            if(i>=4)
            {
                if(x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2])
                    return true;
            }
            if(i>=5)
            {
                if(x[i]+x[i-4]>=x[i-2] && x[i-1]+x[i-5]>=x[i-3] && x[i-2]>=x[i-4] && x[i-1]<=x[i-3])
                    return true;
            }
        }
        return false;
    }
}
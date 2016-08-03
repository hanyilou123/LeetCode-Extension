public class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        long start=1, end=x;
        while(start+1<end)
        {
            long mid = (start+end)/2;
            if(mid*mid=(long)x)
                return (int)mid;
            else if(mid*mid<x)
                start=mid;
            else
                end=mid;
        }
        if(end*end<=x)
            return (int)end;
        return (int)start;
    }
}
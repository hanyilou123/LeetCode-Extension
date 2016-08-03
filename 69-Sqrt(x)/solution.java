public class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        long start=1, end=x, temp=x;
        while(start+1<end)
        {
            long mid = (start+end)/2;
            if(mid*mid==temp)
                return (int)mid;
            else if(mid*mid<temp)
                start=mid;
            else
                end=mid;
        }
        if(end*end<=x)
            return (int)end;
        return (int)start;
    }
}
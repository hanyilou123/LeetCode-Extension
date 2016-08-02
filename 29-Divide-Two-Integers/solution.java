public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0)
            return dividend>0?Integer.MAX_VALUE: Integer.MIN_VALUE;
        if(dividend==0)
            return 0;
        if(dividend==Integer.MAX_VALUE && divisor==-1)
            return Integer.MIN_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        int result=0, sign=1;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0))
            sign=-1;
        else
            sign=1;
        long a=Math.abs((long)(dividend));
        long b=Math.abs((long)(divisor));
        while(a>=b)
        {
            int time=0;
            while(a>=(b<<time))
            {
                time++;
            }
            a -= b<<(time-1);
            result += 1<<(time-1);
        }
        return result*sign;
    }
}
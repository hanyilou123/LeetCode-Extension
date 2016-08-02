public class Solution {
    public double myPow(double x, int n) {
        double result=1.0;
        if(x==0.0)
            return 0.0;
        if(n==0)
            return 1;
        else if(n>0)
        {
            while(n>0)
            {
                result *= x;
                n--;
            }
        }
        else
        {
            while(n<0)
            {
                result *= x;
                n++;
            }
            result = 1/result;
        }
        return result;
    }
}
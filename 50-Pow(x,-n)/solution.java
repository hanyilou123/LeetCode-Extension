public class Solution {
    public double myPow(double x, int n) {
        double result=1.0;
        if(n==0)
            return 1;
        if(n==1)
            return x;
        int flag=0;
        
        int half=0, remain=0;
        if(n<0)
        {
            half = n/2;
            remain = half*2-n;
            half *= -1;
            flag = 1;
        }
        else
        {
            half = n/2;
            remain = n-half*2;
        }
        double t1 = myPow(x, half);
        double t2 = myPow(x, remain);
        if(flag==1)
        {
            result = 1/(t1*t1*t2);
        }
        else{
            result = t1*t1*t2;
        }
        
        return result;
    }
}
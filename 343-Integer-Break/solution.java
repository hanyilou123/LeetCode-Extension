public class Solution {
    public int integerBreak(int n) {
        if(n<4)
            return n-1;
        int res=1;
        while(n>2)
        {
            res *=3;
            n -=3;
        }
        if(n==0)
            return res;
        if(n==1)
            return res/3*4;
        if(n==2)
            return res*2;
        return 0;
    }
}
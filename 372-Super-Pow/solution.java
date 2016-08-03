public class Solution {
    public int superPow(int a, int[] b) {
        int res=1;
        for(int i=0; i<b.length; i++)
        {
            res = pow(res, 10)*pow(a, b[i])%1337;
        }
    }
    public int pow(int a, int n)
    {
        if(n==0)
            return 1;
        if(n==1)
            return a%1337;
        return pow(a%1337, n/2)*pow(a%1337, n-n/2)%1337;
    }
}
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n)
            return m;
        int step=0;
        while(m<n)
        {
            n = n&(n-1);
        }
        return n;
    }
}
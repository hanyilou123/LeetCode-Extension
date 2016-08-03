public class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int r=1;
        while(r*r<x)
            r++;
        return Math.rint(--r);
    }
}
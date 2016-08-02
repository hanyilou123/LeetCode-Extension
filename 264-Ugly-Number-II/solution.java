public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] res = new int[n];
        res[0] = 1;
        int part2=2, part3=3, part5=5;
        int index2=0, index3=0, index5=0;
        for(int i=1; i<n; i++)
        {
            int min = Math.min(Math.min(part2, part3, part5));
            if(min==part2)
                part2=2*res[++index2];
            if(min==part3)
                part3=3*res[++index3];
            if(min==part5)
                part5=5*res[++index5];
        }
        return res[n-1];
    }
}
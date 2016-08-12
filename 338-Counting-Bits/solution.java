public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num.length];
        for(int i=1; i<num.length; i++)
        {
            res[i] = res[i>>1] + (num[i] & 1);
        }
        return res;
    }
}
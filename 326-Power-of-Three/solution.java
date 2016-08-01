public class Solution {
    public boolean isPowerOfThree(int n) {
        double res = Math.log(n)/Math.log(3);
        return Math.abs(res-Math.rint(res))<0.0000000001;
    }
}
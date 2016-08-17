public class Solution {
    public boolean isPowerOfFour(int num) {
        return num>0 && (int)(Math.log(num)/Math.log(4))-(Math.log(num)/Math.log(4))==0;
    }
}
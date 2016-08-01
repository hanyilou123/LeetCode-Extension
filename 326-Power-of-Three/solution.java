public class Solution {
    public boolean isPowerOfThree(int n) {
        // double res = Math.log(n)/Math.log(3);
        // return Math.abs(res-Math.rint(res))<0.0000000001;
        while(n>=1)
        {
            if(n==1)
                return true;
            int last_digit = n%10;
            if((last_digit!=1 && last_digit!=3 && last_digit!=7 && last_digit!=9) || n%3!=0)
                return false;
            else
                n/=3;
        }
        return n>0?true:false;
    }
}
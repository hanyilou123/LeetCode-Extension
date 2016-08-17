public class Solution {
    public int getSum(int a, int b) {
        // while(b>0)
        // {
        //     int carry = a & b;
        //     a = a ^ b;
        //     b = carry << 1;
        // }
        // return a;
        if(b==0)
            return a;
        int sum=0, carry=0;
        sum = a^b;
        carry = (a&b)<<1;
        return getSum(sum, carry);
    }
}
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n>=10)
            n=10;
        if(n==0)
            return 1;
        int result=10, temp=9;
        for(int i=2; i<=n; i++)
        {
            temp *= (11-i);
            result += temp;
        }
        
        return result;
    }
}
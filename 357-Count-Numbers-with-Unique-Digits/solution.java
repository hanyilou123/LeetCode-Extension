public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n>=10)
            n=10;
        if(n==0)
            return 1;
        int result=0;
        for(int i=1; i<=n; i++)
        {
            int bigrow=9;
            if(i==1)
                bigrow=10;
            else
            {
                int j=9;
                while(i+j>10)
                {
                    bigrow *= j;
                    j--;
                }
            }
            result += bigrow;
        }
        return result;
    }
}
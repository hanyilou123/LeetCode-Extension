public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return dpProcess(dp, 1, n);
    }
    public int dpProcess(int[][] dp, int start, int end)
    {
        if(start>=end) 
            return 0;
        if(dp[start][end]!=0)
            return dp[start][end];
        int minVal = 0;
        for(int i=start; i<=end; i++)
        {
            int temp = i + Math.max(dpProcess(start, i-1), dpProcess(i+1, end));
            minVal = Math.min(minVal, temp);
        }
        dp[start][end] = minVal;
        return minVal;
    }
}
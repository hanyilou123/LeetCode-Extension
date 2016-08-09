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
        int minVal = Integer.MAX_VALUE;
        for(int i=start; i<=end; i++)
        {
            int temp = i + Math.max(dpProcess(dp, start, i-1), dpProcess(dp, i+1, end));
            minVal = Math.min(minVal, temp);
        }
        dp[start][end] = minVal;
        return minVal;
    }
}
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for(int i=1; i<=amount; i++)
        {
            int minval = Integer.MAX_VALUE-1; //如果minval=Integer.MAX_VALUE, dp[i-coins[j]]+1 可能就溢出了
            for(int j=0; j<coins.length; j++)
            {
                if(i-coins[j]<0)
                    break;
                minval = Math.min(minval, dp[i-coins[j]]+1);
            }
            dp[i] = minval;
        }
        if(dp[amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[amount];
    }
}
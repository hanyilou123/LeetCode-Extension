public class Solution {
    public class compareD implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b-a;
        }
    }
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return 0;
        Arrays.sort(coins, new compareD());
        int[] dp = new int[amount+1];
        for(int i=0; i<=amount; i++)
        {
            for(int j=coins.length-1; j>=0; j--)
            {
                if(i-coins[j]>0)
                    dp[i] += dp[i-coins[j]];
                else if(i-coins[j]==0)
                    dp[i] += 1;
            }
        }
        return dp[amount];
    }
}
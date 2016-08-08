public class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] newNums = new int[nums.length+2];
        int n=1;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)
                newNums[n++]=nums[i];
        }
        newNums[0]=newNums[n++]=1;
        
        int[][] dp = new int[n][n];
        for(int k=2; k<n; k++)
        {
            for(int left=0; left+k<n; left++)
            {
                int right = left+k;
                for(int i=left+1; i<right; i++)
                {
                    dp[left][right] = Math.max(dp[left][right], newNums[left]*newNums[i]*newNums[right]+dp[left][i]+dp[i][right]);
                }
            }
        }
        return dp[0][n-1];
    }
}
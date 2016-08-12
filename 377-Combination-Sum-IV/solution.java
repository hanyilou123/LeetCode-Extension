public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp = new int[target+1];
        for(int i=0; i<=target; i++)
        {
            for(int j=0; j<nums.length; j++)
            {
                if(i-nums[j]>0)
                {
                    dp[i] += dp[i-nums[j]];
                }
                else if(i-nums[j]==0)
                    dp[i] += 1;
            }
        }
        return dp[target];
    }
}
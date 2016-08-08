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
        
        int[][] memo = new int[n][n];
        return burst(memo, newNums, 0, n-1);
    }
    public int burst(int[][] memo, int[] newNums, int left, int right)
    {
        if(left+1==right)
            return 0;
        if(memo[left][right]>0)
            return memo[left][right];
        int ans = 0;
        for(int i=left+1; i<right; i++)
        {
            ans = Math.max(ans, newNums[left]*newNums[i]*newNums[right]+burst(memo, newNums, left, i)+burst(memo, newNums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}
public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        int max1=0, max2=0;
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0]=nums[0];
        dp1[1] = nums[0];
        dp2[0]=0;
        dp2[1]=nums[1];
        for(int i=2; i<len-1; i++)
        {
            dp1[i]=Math.max(nums[i]+dp1[i-2], dp1[i-1]);
            dp2[i]=Math.max(nums[i]+dp2[i-2], dp2[i-1]);
        }
        max1=dp1[len-2];
        dp2[len-1]=Math.max(nums[len-1]+dp2[len-3], dp2[len-2]);
        max2=dp2[len-1];
        
        // for(int i=2; i<len; i++)
        // {
        //     dp2[i]=Math.max(nums[i]+dp2[i-2], dp2[i-1]);
        // }
        
        return Math.max(max1, max2);
    }
}
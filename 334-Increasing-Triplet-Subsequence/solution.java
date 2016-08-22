public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<3)
            return false;
        int small = Integer.MAX_VALUE;
        int mid = Integer.Max_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]<=small)
            {
                small = nums[i];
            }
            else if(nums[i]<=mid)
            {
                mid = nums[i];
            }
            else
                return true;
        }
        return false;
    }
}
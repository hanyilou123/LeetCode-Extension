public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<2)
            return nums.length;
        boolean big = nums[0] < nums[1];
        int count=1;
        for(int i=1; i<nums.length; i++)
        {
            if((big && nums[i]>nums[i-1]) || (!big && nums[i]<nums[i-1]))
            {
                count++;
                big = !big;
            }
        }
        return count;
    }
}
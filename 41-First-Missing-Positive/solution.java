public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null)
            return 1;
        int n = nums.length, temp=0;
        for(int i=0; i<n; i++)
        {
            while(nums[i]>0 && nums[i]<=n && nums[i]!=i+1)
            {
                temp = nums[i];
                if(nums[nums[i]-1]==nums[i])
                    break;
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }
        for(int i=0; i<n; i++)
        {
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }
}
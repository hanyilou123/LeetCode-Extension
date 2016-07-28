public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null)
            return 1;
        int n = nums.length, pos=0, temp=0;
        while(pos<n)
        {
            if(nums[pos]>0 && nums[pos]<=n && nums[pos]!=pos+1 && nums[nums[pos]-1]!=nums[pos])
            {
                temp = nums[pos];
                nums[pos] = nums[nums[pos]-1];
                nums[nums[pos]-1] = temp;
            }
            else
            {
                ++pos;
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
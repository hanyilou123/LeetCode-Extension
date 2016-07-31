public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int[] bitnum = new int[32];
        int res = 0;
        for(int i=0; i<32; i++)
        {
            for(int j=0; j<nums.length; j++)
            {
                bitnums[i] += (nums[j]>>i & 0x1);
            }
            res |= (bitnums%3<<i);
        }
        return res;
    }
}
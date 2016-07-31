public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int xor = 0;
        for(int i=0; i<nums.length; i++)
        {
            xor ^= nums[i];
        }
        int[] res = new int[2];
        int lastBit = xor & (~xor+1);
        for(int i=0; i<nums.length; i++)
        {
            if(lastBit & nums[i]==0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }
        return res;
    }
}
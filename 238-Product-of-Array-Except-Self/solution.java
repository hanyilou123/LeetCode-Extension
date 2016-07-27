public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] res = new int[len];
        res[len-1] = nums[len-1];
        for(int i=len-2; i>=0; i--)
        {
            res[i] = nums[i];
            res[i] = res[i]*res[i+1];
        }
        int pro = 1;
        for(int i=0; i<len-1; i++)
        {
            res[i] = res[i+1]*pro;
            pro *= nums[i];
        }
        res[len-1] = pro;
        return res;
    }
}
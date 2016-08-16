public class Solution {
    public int minPatches(int[] nums, int n) {
        if(nums==null || nums.length==0)
            return 0;
        int known=1, count=0, i=0;
        while(know<n)
        {
            if(know>=nums[i])
                know+=nums[i];
            else{
                know +=know;
                count++;
            }
        }
        return count;
    }
}
public class Solution {
    public int minPatches(int[] nums, int n) {
        int known=1, count=0, i=0;
        while(known<=n)
        {
            if(i<nums.length && known>=nums[i])
                known+=nums[i++];
            else{
                known <<1;
                count++;
            }
        }
        return count;
    }
}
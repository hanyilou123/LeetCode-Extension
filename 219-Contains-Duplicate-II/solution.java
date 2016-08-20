public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0)
            return false;
        Set<Integer> myset = new HashSet<Integer>();
        int start=0, end=0;
        for(int i=0; i<nums.length; i++)
        {
            if(!myset.add(nums[i]))
                return true;
            else{
                end++;
            }
            if(end-start>k)
            {
                myset.remove(nums[start]);
                start++;
            }
        }
        return false;
    }
}
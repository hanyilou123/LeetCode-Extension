public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Set<Integer> hash = new HashSet<Integer>();    //空间换时间
        for(int i=0; i<nums.length; i++)
        {
            hash.add(nums[i]);
        }
        int longest = 0;
        for(int i=0; i<nums.length; i++)
        {
            int down=nums[i]-1;
            while(hash.contains(down))
            {
                hash.remove(down);
                down--;
            }
            int up = nums[i]+1;
            while(hash.contains(up))
            {
                hash.remove(up);
                up++;
            }
            longest = Math.max(longest, up-down-1);
        }
        return longest;
    }
}
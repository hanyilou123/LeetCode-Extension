public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null)
            return 1;
        // int n = nums.length, pos=0;
        // while(pos<n)
        // {
        //     if(nums[pos]>0 && nums[pos]<=n && nums[pos]!=pos+1 && nums[nums[pos]-1]!=nums[pos])
        //     {
        //         int temp = nums[pos];
        //         nums[pos] = nums[nums[pos]-1];
        //         nums[nums[pos]-1] = temp;
        //     }
        //     else
        //     {
        //         ++pos;
        //     }
        // }
        // for(int i=0; i<n; i++)
        // {
        //     if(nums[i]!=i+1)
        //         return i+1;
        // }
        // return n+1;
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            s.add(nums[i]);
        }
        int res = 1;
        for(res = 1; res<=Integer.MAX_VALUE;res++){
            if(!s.contains(res)) break;
        }
        return res;
    }
}
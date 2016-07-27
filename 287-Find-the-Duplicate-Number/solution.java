public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int len = nums.length;
        int low=1, height=len-1, count=0;
        while(low<height)
        {
            int mid = (low+height)/2;
            count = 0;
            for(int i=0; i<nums.length; i++)
            {
                if(nums[i]<=mid)
                    count++;
            }
            if(count>mid)
                height = mid;
            else
                low = mid+1;
        }
        return low;
    }
}
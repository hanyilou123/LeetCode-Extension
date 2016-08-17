public class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;
        int min=nums[0], max=nums[0];
        for(int i=1; i<nums.length; i++)
        {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if(min==max)
            return 0;
        int len = nums.length;
        int gap = (int) Math.ceil((double)(max-min)/(len-1));
        int[] bucketMin = new int[len];
        int[] bucketMax = new int[len];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        for(int i=0; i<len; i++)
        {
            int idx = (nums[i]-min)/gap;
            bucketMin[idx] = Math.min(bucketMin[idx], nums[i]);
            bucketMax[idx] = Math.max(bucketMax[idx], nums[i]);
        }
        for(int i=0; i<bucketMin.length; i++)
        {
            if(bucketMin[i]!=Integer.MAX_VALUE)
            {
                gap = Math.max(gap, bucketMin[i]-min);
                min = bucketMax[i];
            }
        }
        return gap;
    }
}
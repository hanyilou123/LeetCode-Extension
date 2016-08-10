public class Solution {
   public int lengthOfLIS(int[] nums) {
        int[] maxLen = new int[nums.length+1];
        maxlen[0] = -1;
        for(int i=1; i<=nums.length; i++)
        {
            maxlen[i]=Integer.MAX_VALUE;
        }
        for(int i=0; i<nums.length; i++)
        {
            int index = binarySearch(maxlen, nums[i]);
            maxlen[index] = nums[i];
        }
        for(int i=maxlen.length-1; i>=1; i--)
        {
            if(maxlen[i]!=Integer.MAX_VALUE)
                return i;
        }
        return 0;
    }
    public int binarySearch(int[] maxLen, int target)
    {
        int start=0, end=maxlen.length-1;
        while(start<end)
        {
            int mid = start+(end-start)/2;
            if(maxlen[mid]<target)
                start=mid+1;
            else 
                end = mid;
        }
        return start;
    }
}
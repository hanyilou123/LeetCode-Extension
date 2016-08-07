public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0)
            return 0;
        return helper(nums, 0, nums.length, nums.length-k+1);
    }
    public int helper(int[] nums, int l, int r, int k)
    {
        if(l==r)
            return nums[l];
        int pos = patition(nums, l, r);
        if(pos+1==k)
        {
            return nums[pos];
        }
        else if(pos+1<k)
        {
            return helper(nums, pos+1, r, k);
        }
        else
        {
            return helper(nums, l, pos-1, k);
        }
    }
    public int patition(int[] nums, int l, int r)
    {
        int left=l, right=r, pivot = nums[l];
        while(left<right)
        {
            while(left<right && nums[right]>=pivot)
            {
                right--;
            }
            nums[left]=nums[right];
            while(left<right && nums[left]<=pivot)
            {
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=pivot;
        return left;
    }
}
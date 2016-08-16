public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        Arrays.sort(nums);
        int small=(nums.length-1)/2, big=nums.length-1;
        int[] temp = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            temp[i] = (i&1)==0?nums[small--]:nums[big--];
        }
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = temp[i];
        }
    }
}
public class Solution {
    int[] nums;
    Random rd;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rd = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums==null)
            return null;
        int[] sf = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            sf[i] = nums[i];
        for(int i=1; i<sf.length; i++)
        {
            int exch = rd.nextInt(i+1);
            int temp = sf[i];
            sf[i] = sf[exch];
            sf[exch] = temp;
        }
        return sf;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
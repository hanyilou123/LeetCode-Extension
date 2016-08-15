public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0)
            return new int[0];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        int idx=0;
        for(int i=0; i<nums.length; i++)
        {
            while(!dq.isEmpty() && dq.peek()<i-k+1)
            {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
            {
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1)
            {
                res[idx++]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
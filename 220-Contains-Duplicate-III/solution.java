public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1 || t<0)
            return false;
        Map<Long, Long> bucketMap = new HashMap<Long, Long>();
        for(int i=0; i<nums.length; i++)
        {
            long reMapNum = (long)nums[i]-Integer.MIN_VALUE;
            long bucket = reMapNum/(t+1);
            if(bucketMap.containsKey(bucket) || (bucketMap.containsKey(bucket-1) && reMapNum-bucketMap.get(bucket-1)<=t) || (bucketMap.containsKey(bucket+1) && bucketMap.get(bucket-1)-reMapNum<=t))
                return true;
            if(bucketMap.size>k)
            {
                long lastOne = ((long)nums[i-k]-Integer.MIN_VALUE)/(t+1);
                bucketMap.remove(lastOne);
            }
            bucketMap.put(bucket, reMapNum);
        }
        return false;
    }
}
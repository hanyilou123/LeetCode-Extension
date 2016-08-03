public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length==0)
            return result;
        if(nums.length==1)
        {
            result.add(nums[0]);
            return result;
        }
            
        int len = nums.length, max=0, maxindex=0;
        int[] count = new int[len];
        int[] parent = new int[len];
        Arrays.sort(nums);
        for(int i=len-1; i>=0; i--)
        {
            for(int j=i; j<len; j++)
            {
                if(nums[j]%nums[i]==0 && count[i]<count[j]+1)
                {
                    count[i] = count[j]+1;
                    parent[i] = j;
                    if(count[i]>max)
                    {
                        max = count[i];
                        maxindex = i;
                    }
                }
            }
        }
        for(int i=0; i<max; i++)
        {
            result.add(nums[maxindex]);
            maxindex = parent[maxindex];
        }
        return result;
    }
}
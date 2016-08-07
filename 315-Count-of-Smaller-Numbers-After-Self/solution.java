public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length()==0)
            return result;
        int count=0;
        for(int i=0; i<nums.length-1; i++)
        {
            count=0;
            for(int j=i+1; j<nums.length-1; j++)
            {
                if(nums[j]<nums[i])
                    count++;
            }
            result.add(count);
        }
        return result;
    }
}
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums==null || nums.length==0)
            return res;
        String temp = ""+nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]-nums[i-1]==1)
            {
                start = 0;
                continue;
            }
            else{
                temp += "->"+nums[i-1];
                res.add(temp);
                temp = ""+nums[i];
            }
        }
        temp+="->"+nums[nums.length-1];
        res.add(temp);
        return res;
    }
}
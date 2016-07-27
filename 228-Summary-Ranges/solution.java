public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums==null || nums.length==0)
            return res;
        int start=1, flag=1;
        String temp = ""+nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]-nums[i-1]==1)
            {
                start = 0;
                continue;
            }
            else{
                start = 1;
                if(flag!=1)
                {
                    temp += "->"+nums[i-1];
                }
                res.add(temp);
                temp = ""+nums[i];
                flag==0;
            }
        }
        if(start==0)
            temp+="->"+nums[nums.length-1];
        res.add(temp);
        return res;
    }
}
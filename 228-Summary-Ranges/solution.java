public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums==null || nums.length==0)
            return res;
        String temp = ""+nums[0];
        int count=1;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]-nums[i-1]==1)
            {
                if(i==nums.length-1)
                    temp += "->"+nums[i];
                count++;
                continue;
            }
            else{
                if(count>1)
                    temp += "->"+nums[i-1];
                res.add(temp);
                temp = ""+nums[i];
                count=1;
            }
        }
        //temp+="->"+nums[nums.length-1];
        res.add(temp);
        return res;
    }
}
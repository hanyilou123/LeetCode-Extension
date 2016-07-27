public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null || nums.length==0)
            return res;
        int count1=0, count2=0, cand1=0, cand2=1;  //make sure these two candidates are different
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==cand1)
                count1++;
            else if(nums[i]==cand2)
                count2++;
            else if(count1==0)
            {
                cand1 = nums[i];
                count1 = 1;
            }
            else if(count2==0)
            {
                cand2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0; count2=0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==cand1)
                count1++;
            if(nums[i]==cand2)
                count2++;
        }
        if(count1>nums.length/3)
            res.add(cand1);
        if(count2>nums.length/3)
            res.add(cand2);
        return res;
    }
}
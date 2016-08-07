public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length==0)
            return sorted;
        int len = nums.length;
        int[] ans = new int[len];
        for(int i=nums.length-1; i>=0; i--)
        {
            int index = findIndex(sorted, nums[i]);
            //  ans[i] = index;
            result.add(0, index);
            sorted.add(index, nums[i]);
        }
        return result;
    }
    public int findIndex(List<Integer> sorted, int target)
    {
        if(sorted.size()==0)
            return 0;
        int start=0, end=sorted.size()-1;
        if(sorted.get(end)<target)
            return end+1;
        if(sorted.get(start)>target)
            return 0;
        while(start+1<end)
        {
            int mid = (start+end)/2;
            if(sorted.get(mid)<target)
                start=mid+1;
            else
                end =mid;
        }
        if(sorted.get(start)>=target)
            return start;
        return end;
    }
}
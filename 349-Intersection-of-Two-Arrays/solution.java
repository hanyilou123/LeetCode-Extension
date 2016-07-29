public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return null;
        Set<Integer> res1 = new HashSet<Integer>();
        Set<Integer> res2 = new HashSet<Integer>();
        
        for(int i=0; i<nums1.length; i++)
            res1.add(nums1[i]);
        for(int i=0; i<nums2.length; i++)
        {
            if(res1.contains(nums2[i]) && !res2.contains(nums[i]))
                res2.add(nums2[i]);
        }
        
        int size = res2.size();
        int[] result = new int[size];
        int index = 0;
        for(int each : res2)
        {
            result[index++] = each;
        }
        return result;
    }
}
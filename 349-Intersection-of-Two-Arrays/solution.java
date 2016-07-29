public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return null;
        Set<Integer> res1 = new HashSet<Integer>();
        Set<Integer> res2 = new HashSet<Integer>();
        Set<Integer> res3 = new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++)
            res1.add(nums1[i]);
        for(int i=0; i<nums2.length; i++)
            res2.add(nums2[i]);
        for(int i=0; i<res1.size(); i++)
        {
            if(res2.contains(res1.get(i)))
                res3.add(res1.get(i));
        }
        if(res3)
        {
            int[] result = new int[res3.size()];
            for(int i=0; i<res3.size(); i++)
            {
                result[i] = res3.get(i);
            }
        }
        return result;
    }
}
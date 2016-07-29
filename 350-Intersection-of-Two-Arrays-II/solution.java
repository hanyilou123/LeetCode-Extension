public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return null;
        Map<Integer, Integer> res1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> res2 = new HashMap<Integer, Integer>();
        for(int i=0; i<nums1.length; i++)
        {
            if(res1.containsKey(nums1[i]))
            {
                int num = res1.get(nums1[i]);
                res1.put(nums1[i], ++num);
            }
            else
                res1.put(nums1[i], 1);
        }
        for(int i=0; i<nums2.length; i++)
        {
            if(res1.containsKey(nums2[i]))
            {
                if(res2.containsKey(nums2[i]))
                {
                    int num = Math.min(res1.get(nums2[i]), (res2.get(nums2[i])+1));
                    res2.put(nums2[i], num);
                }
                else{
                    res2.put(nums2[i], 1);
                }
            }
        }
        int size=0;
        for(Entry<Integer, Integer> entry : res2.entrySet())
        {
            size+=entry.getValue();
        }
        int[] result = new int[size];
        int index=0;
        for(Entry<Integer, Integer> entry : res2.entrySet())
        {
            for(int i=0; i<entry.getValue(); i++)
            {
                result[index++]=entry.getKey();
            }
        }
        return result;
    }
}
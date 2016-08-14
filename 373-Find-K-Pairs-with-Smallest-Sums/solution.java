public class Solution {
    public class pairComp implements Comparator<int[]>{
        public int compare(int[] a, int[] b)
        {
            return (a[0]+a[1])-(b[0]+b[1]);
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return result;
        int l1=nums1.length, l2=nums2.length;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new pairComp());
        for(int i=0; i<l1; i++)
        {
            for(int j=0; j<l2; j++)
            {
                heap.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        for(int i=0; i<k && i<(l1*l2); i++)
        {
            result.add(heap.poll());
        }
        return result;
    }
}
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations,comparator.reversed();
        int len = citations.length;
        int hIndex = 0;
        for(int i=0; i<len; i++)
        {
            if(i>=citations[i])
            {
                return i;
            }
        }
        return len;
    }
}
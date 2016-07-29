public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int hIndex = 0;
        for(int i=0; i<len; i++)
        {
            if(len-i>=citations[i])
            {
                hIndex = Math.max(hIndex, citation[i]);
            }
        }
        return hIndex;
    }
}
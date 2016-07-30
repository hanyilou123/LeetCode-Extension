public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int hIndex = 0;
        for(int i=len-1; i>=0; i--)
        {
            if(len-1-i>=citations[i])
            {
                return len-1-i;
            }
        }
        return len;
    }
}
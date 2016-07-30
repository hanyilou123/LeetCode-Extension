public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int[] newci = new int[len];
        for(int i=len-1; i>=0; i--)
        {
            newci[len-1-i] = citations[i];
        }
        int hIndex = 0;
        for(int i=0; i<len; i++)
        {
            if(i>=newci[i])
            {
                return i;
            }
        }
        return len;
    }
}
public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        int len=citations.length;
        int start=0, end =len-1;
        while(start<end)
        {
            int mid = start+(end-start)/2;
            if(len-1-mid=citations[mid])
                return len-1-mid;
            else if(len-1-mid<citations[mid])
                start=mid+1;
            else
                end = mid;
        }
        return len-1-start;
    }
}
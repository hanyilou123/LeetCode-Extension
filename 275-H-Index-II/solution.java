public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        int len=citations.length;
        int start=0, end =len;
        while(start<end)
        {
            int mid = start+(end-start)/2;
            if(len-mid==citations[mid])
                return len-mid;
            else if(len-mid>citations[mid])
                start=mid+1;
            else
                end = mid;
        }
        return len-start;
    }
}
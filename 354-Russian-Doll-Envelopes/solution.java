public class Solution {
    public class sortEnv implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0]==b[0])
                return b[1]-a[1];
            else
                return a[0]-b[0];
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0)
            return 0;
        Arrays.sort(envelopes, new sortEnv());
        int[] dp = new int[envelopes.length];
        int len=0;
        for(int i=0; i<envelopes.length; i++)
        {
            int index = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
            if(index<0)
                index = -(index+1);
            dp[index] = envelopes[i];
            if(index==len)
                len++;
        }
        return len;
    }
}
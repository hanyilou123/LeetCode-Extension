public class Solution {
    public int minCut(String s) {
        if(s==null || s.length()==0)
            return 0;
        int len = s.length();
        int[] count = new int[len+1];
        int[][] dp = new int[len][len];
        
        for(int i=len-1; i>=0; i--)
        {
            count[i] = Integer.MAX_VALUE; 
            for(int j=i; j<len; j++)
            {
                if(s.charAt(i)==s.charAt(j) && ((j-i)<2 || dp[i+1][j-1]==1))
                {
                    dp[i][j]=1;
                    count[i] = Math.min(count[i], count[j+1]+1);
                }
            }
        }
        return count[0]-1;
    }
}
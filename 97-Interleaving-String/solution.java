public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
            return false;
        if(s1==null || s1.length()==0)
            return s2.equals(s3);
        if(s2==null || s2.length()==0)
            return s1.equals(s3);
        int l1=s1.length(), l2=s2.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int i=0; i<l1; i++)
        {
            if(s1.charAt(i)==s3.charAt(i) && dp[i-1][0])
                dp[i][0]=true;
        }
        for(int i=0; i<l2; i++)
        {
            if(s2.charAt(i)==s3.charAt(i) && dp[0][i-1])
                dp[0][i]=true;
        }
        for(int i=1; i<=l1; i++)
        {
            for(int j=1; j<=l2; j++)
            {
                if((s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j]) ||
                    (s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]))
                    dp[i][j] = true;
            }
        }
        return dp[l1][l2];
    }
}
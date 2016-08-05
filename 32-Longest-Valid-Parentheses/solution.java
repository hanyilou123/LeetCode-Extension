public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
        int maxlen=0;
        int[] dp = new int[s.length()];
        for(int i=s.length()-2; i>=0; i--)
        {
            if(s.charAt(i)=='(')
            {
                int end = i+dp[i+1]+1;
                if(end<s.length() && s.charAt(end)==')')
                {
                    dp[i] = dp[i+1]+2;
                    if(end+1<s.length())
                    {
                        dp[i] += dp[end+1];
                    }
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }
}
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int m=matrix.length, n=matrix[0].length, max=0;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++)
        {
            if(matrix[i][0]=='1')
            {
                dp[i][0]=1;
                max=1;
            }
        }
        for(int j=0; j<n; j++)
        {
            if(matrix[0][j]=='1')
            {
                dp[0][j]=1;
                max=1;
            }
        }
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(matrix[i][j]=='0')
                    dp[i][j]=0;
                else
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
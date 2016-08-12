public class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        int m=matrix.length;
        int n=matrix[0].length;
        dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        this.dp=dp;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int minR = Math.min(row1, row2);
        int maxR = Math.max(row1, row2);
        int minC = Math.min(col1, col2);
        int maxC = Math.max(col1, col2);
        
        return dp[maxR+1][maxC+1]-dp[minR][maxC+1]-dp[maxR+1][minC]+dp[minR][minC];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
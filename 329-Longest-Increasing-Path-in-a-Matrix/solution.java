public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int maxValue = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix.length; j++)
            {
                dfs(matrix, i, j, 1);
            }
        }
        return maxValue;
    }
    public void dfs(int[][] matrix, int i, int j, int count)
    {
        for(int k=0; k<dx.length; k++)
        {
            if(i+dx[k]>=0 && i+dx[k]<matrix.length && j+dy[k]>=0 && j+dy[k]<matrix[i].length 
            && matrix[i+dx[k]][j+dy[k]]>matrix[i][j])
            {
                maxValue=Math.max(maxValue, count+1);
                dfs(matrix, i+dx[k], j+dy[k], count+1);
            }
        }
    }
}
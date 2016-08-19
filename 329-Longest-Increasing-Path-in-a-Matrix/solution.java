public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxValue = 1;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                int length = dfs(matrix, i, j, 1, cache);
                maxValue = Math.max(length, maxValue);
            }
        }
        return maxValue;
    }
    public int dfs(int[][] matrix, int i, int j, int count, int[][] cache)
    {
        if(cache[i][j]>0)
            return cache[i][j];
        int max=1;
        for(int k=0; k<dx.length; k++)
        {
            if(i+dx[k]>=0 && i+dx[k]<matrix.length && j+dy[k]>=0 && j+dy[k]<matrix[i].length && matrix[i+dx[k]][j+dy[k]]>matrix[i][j])
            {
                int len = 1+dfs(matrix, i+dx[k], j+dy[k], count+1, cache);
                max=Math.max(max, len);
            }
        }
        cache[i][j]=max;
        return max;
    }
}
public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int count=0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]=='1')
                {
                    exploreProcess(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void exploreProcess(char[][] grid, int i, int j)
    {
        grid[i][j]='x';
        for(int k=0; k<dx.length; k++)
        {
            if(i+dx[k]>=0 && i+dx[k]<grid.length && j+dy[k]>=0 && j+dy[k]<grid[0].length && grid[i+dx[k]][j+dy[k]])
                exploreProcess(grid, [i+dx[k]], [j+dy[k]);
        }
    }
}
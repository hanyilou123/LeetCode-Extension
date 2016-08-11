public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0)
            return 0;
        int m = dungeon.length, n=dungeon[0].length;
        // int[][] health = new int[m][n];
        dungeon[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        for(int i=m-2; i>=0; i--)
            dungeon[i][n-1] = Math.max(dungeon[i+1][n-1]-dungeon[i][n-1], 1);
        for(int i=n-2; i>=0; i--)
            dungeon[m-1][i] = Math.max(dungeon[m-1][i+1]-dungeon[m-1][i], 1);
        for(int i=m-2; i>=0; i--)
        {
            for(int j=n-2; j>=0; j--)
            {
                int right = Math.max(dungeon[i][j+1]-dungeon[i][j], 1);
                int down = Math.max(dungeon[i+1][j]-dungeon[i][j], 1);
                dungeon[i][j] = Math.min(right, down);
            }
        }
        return dungeon[0][0];
    }
}
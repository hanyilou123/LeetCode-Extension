public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        for(int i=0; i<9; i++)
        {
            Arrays.fill(visited, false);
            for(int j=0; j<9; j++)
            {
                if(!visitProcess(board[i][j], visited))
                    return false;
            }
        }
        for(int i=0; i<9; i++)
        {
            Arrays.fill(visited, false);
            for(int j=0; j<9; j++)
            {
                if(!visitProcess(board[j][i], visited))
                    return false;
            }
        }
        for(int i=0; i<9; i+=3)
        {
            for(int j=0; j<9; j+=3)
            {
                Arrays.fill(visited, false);
                for(int k=0; k<9; k++)
                {
                    if(!visitProcess(board[i+k/3][j+k%3], visited))
                        return false;
                }
            }
        }
        return true;
    }
    public boolean visitProcess(char c, boolean[] visited)
    {
        if(c=='.')
            return true;
        int num = c-'0';
        if(num<1 || num>9 || visited[num-1]==true)
            return false;
        visited[num-1] = true;
        return true;
    }
}
public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board)
    {
        int h=board.length, w=board[0].length;
        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
            {
                if(board[i][j]!='.')
                    continue;
                for(int k=1; k<=9; k++)
                {
                    board[i][j] = (char)('0'+k);
                    if(isValid(board, i, j) && solve(board))
                    {
                        return true;
                    }
                    board[i][j]='.';
                }
                return false;
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int h, int w)
    {
        Set<Character> ct = new HashSet<Character>();
        for(int j=0; j<9; j++)
        {
            if(ct.contains(board[h][j]))
                return false;
            if(board[h][j]>='1' && board[h][j]<='9')
                ct.add(board[h][j]);
        }
        
        ct.clear();
        for(int i=0; i<9; i++)
        {
            if(ct.contains(board[i][w]))
                return false;
            if(board[i][w]>='1' && board[i][w]<='9')
                ct.add(board[i][w]);
        }
        
        ct.clear();
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                int m = h/3*3 + i;
                int n = w/3*3 + j;
                if(ct.contains(board[m][n]))
                    return false;
                if(board[m][n]>='1' && board[m][n]<='9')
                    ct.add(board[m][n]);
            }
        }
        return true;
    }
}
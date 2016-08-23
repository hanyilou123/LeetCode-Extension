public class Solution {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0)
            return;
        int row=board.length, col=board[0].length;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if((i==0 || i==row-1 || j==0 || j==col-1) && board[i][j]=='O')
                    dfs(i, j, board);
            }
        }
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(board[i][j]=='*')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }
    public void dfs(int i, int j, char[][] board)
    {
        int row=board.length, col=board[0].length;
        if(i<0 || i>=row || j<0 || j>=col)
            return;
        if(board[i][j]=='X' || board[i][j]=='*')
            return;
        board[i][j]='*';
        for(int k=0; k<dx.length; k++)
        {
            if(i+dx[k]>0 && i+dx[k]<row && j+dy[k]>0 && j+dy[k]<col && board[i+dx[k]][j+dy[k]]=='O')
            {
                dfs(i+dx[k], j+dy[k], board);
            }
        }
    }
}
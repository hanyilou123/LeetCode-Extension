public class Solution {
    int count=0;
    public int totalNQueens(int n) {
        int[] state = new int[n];
        for(int i=0; i<n; i++)
            state[i]=-1;
        solveProcess(state, 0);
        return count;
    }
    public void solveProcess(int[] state, int row)
    {
        int n=state.length;
        if(row==n)
        {
            count++;
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(isValid(row, i, state))
            {
                state[row] = i;
                solveProcess(state, row+1);
                state[row] = -1;
            }
        }
    }
    public boolean isValid(int row, int col, int[] state)
    {
        for(int i=0; i<row; i++)
        {
            if(state[i]==col || Math.abs(row-i)==Math.abs(col-state[i]))
                return false;
        }
        return true;
    }
}
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] state = new int[n];
        for(int i=0; i<n; i++)
            state[i]=-1;
        solveProcess(result, state, row);
        return result;
    }
    public void solveProcess(List<List<String>> result, int[] state, int row)
    {
        int n=state.length;
        if(row==n)
        {
            List<String> solution = new ArrayList<String>();
            for(int i=0; i<n; i++)
            {
                StringBuilder row = new StringBuilder();
                for(int j=0; j<n; j++)
                {
                    if(j==state[i])
                        row.append(".");
                    else 
                        row.append("Q");
                }
                solution.add(row.toString());
            }
            result.add(solution);
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(isValid(row, i, state))
            {
                state[row] = i;
                solveProcess(result, state, row+1);
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
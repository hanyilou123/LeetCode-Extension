public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int up=0, right=n-1, down=n-1, left=0, num = 1;
        while(true)
        {
            for(int i=left; i<=right; i++)
            {
                matrix[up][i] = num++;
            }
            up++;
            if(up>down) break;
            
            for(int i=up; i<=down; i++)
            {
                matrix[i][right] = num++;
            }
            right--;
            if(left>right) break;
            
            for(int i=right; i>=left; i--)
            {
                matrix[down][i] = num++;
            }
            down--;
            if(up>down) break;
            
            for(int i=down; i>=up; i--)
            {
                matrix[i][left] = num++;
            }
            left++;
            if(left>right) break;
        }
        return result;
    }
}
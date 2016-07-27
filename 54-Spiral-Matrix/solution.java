public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0)
            return result;
        int height = matrix.length;
        if(matrix[0]==null || matrix[0].length==0)
            return result;
        int width = matrix[0].length;
        int up=0, right=width-1, down=height-1, left=0;
        while(true)
        {
            for(int i=left; i<=right; i++)
            {
                result.add(matrix[up][i]);
            }
            up++;
            if(up>down) break;
            
            for(int i=up; i<=down; i++)
            {
                result.add(matrix[i][right]);
            }
            right--;
            if(left>right) break;
            
            for(int i=right; i>=left; i--)
            {
                result.add(matrix[down][i]);
            }
            down--;
            if(up>down) break;
            
            for(int i=down; i>=up; i--)
            {
                result.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;
        }
        return result;
    }
}
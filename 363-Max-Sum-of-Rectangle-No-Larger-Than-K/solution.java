public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0)
            return 0;
        int row=matrix.length, col=maxtrix[0].length;
        int[][] vsum = new int[row][col];
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                vsum[i][j] = matrix[i][j];
                if(i>0)
                {
                    vsum[i][j] += vsum[i-1][j];
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<row; i++)
        {
            for(int j=i; j<row; j++)
            {
                TreeSet<Integer> ts = new TreeSet<Integer>();
                int sum=0;
                for(int m=0; m<col; m++)
                {
                    sum+=matrix[j][m];
                    if(i>0)
                        sum-=matrix[i-1][m];
                    if(sum==k)
                        return sum;
                    if(sum<k)
                        maxVal = Math.max(maxVal, sum);
                    Integer other = ts.ceiling(sum-maxVal);
                    ts.add(sum);
                    maxVal = Math.max(maxVal, sum-other);
                }
                
            }
        }
        return maxVal;
    }
}
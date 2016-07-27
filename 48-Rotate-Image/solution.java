public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return;
        int leftTop=0, rightBottom=matrix.length-1;
        while(leftTop<rightBottom)
        {
            process(matrix, leftTop, rightBottom);
            leftTop++; rightBottom--;
        }
    }
    public void process(int[][] matrix, int leftTop, int rightBottom)
    {
        for(int i=0; i<rightBottom-leftTop; i++)
        {
            int temp = matrix[leftTop][leftTop+i];
            matrix[leftTop][leftTop+i] = matrix[rightBottom-i][leftTop];
            matrix[rightBottom-i][leftTop] = matrix[rightBottom][rightBottom-i];
            matrix[rightBottom][rightBottom-i] = matrix[leftTop+i][rightBottom];
            matrix[leftTop+i][rightBottom] = temp;
        }
    }
}
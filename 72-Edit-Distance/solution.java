public class Solution {
    public int minDistance(String word1, String word2) {
        // http://www.cnblogs.com/yuzhangcmu/p/4190264.html
        int l1=word1.length(), l2=word2.length();
        int[][] minD = new int[l1+1][l2+1];
        for(int i=0; i<=l2; i++)
            minD[0][i] = i;
        for(int j=0; j<=l1; j++)
            minD[j][0] = j;
            
        for(int i=1; i<=l1; i++)
        {
            for(int j=1; j<=l2; j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    minD[i][j] = minD[i-1][j-1];
                }
                else
                {
                    minD[i][j] = 1 + Math.min(minD[i-1][j-1], Math.min(minD[i-1][j], minD[i][j-1]));
                }
            }
        }
        return minD[l1][l2];
    }
}
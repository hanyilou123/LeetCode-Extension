public class Solution {
    public class bigHeap implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b-a;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new bigHeap());
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix.length; j++)
            {
                if(maxHeap.size()>=k)
                {
                    if(matrix[i][j]<maxHeap.heap())
                    {
                        maxHeap.poll();
                        maxHeap.offer(matrix[i][j]);
                    }
                }
                else
                {
                    maxHeap.offer(matrix[i][j]);
                }
            }
        }
        return maxHeap.peek();
    }
}
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++)
        {
            int pre = prerequisites[i][1];
            int after = prerequisites[i][0];
            if(matrix[pre][after]==0)
                indegree[after]++;
            matrix[pre][after]=1;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++)
        {
            if(indegree[i]==0)
                que.offer(i);
        }
        int count=0;
        while(!que.isEmpty())
        {
            int cur = que.poll();
            result[count++]=cur;
            for(int i=0; i<numCourses; i++)
            {
                if(matrix[cur][i]!=0)
                {
                    if(--indegree[i]==0)
                    {
                        que.offer(i);
                    }
                }
            }
        }
        if(count==numCourses)
            return result;
        else
            return new int[];
    }
}
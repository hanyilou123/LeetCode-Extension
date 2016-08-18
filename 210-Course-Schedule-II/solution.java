public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] outdegree = new int[numCourses];    //不一定必须要把matrix建立起来，空间超出
        int[] result = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++)
        {
            outdegree[prerequisites[i][1]]++;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++)
        {
            if(outdegree[i]==0)
                que.offer(i);
        }
        int count=numCourses-1;
        while(!que.isEmpty())
        {
            int cur = que.poll();
            result[count--]=cur;
            for(int i=0; i<prerequisites.length; i++)
            {
                int l = prerequisites[i][1];
                if(prerequisites[i][0]==cur)
                {
                    if(--outdegree[l]==0)
                    {
                        que.offer(l);
                    }
                }
            }
        }
        if(count==-1)
            return result;
        else
            return new int[0];
    }
}
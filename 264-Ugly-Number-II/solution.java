public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        q.offer(1);
        for(int i=1; i<n; i++)
        {
            long temp = q.poll();
            while(!q.isEmpty() && q.peek()==temp)
                temp = q.poll();
            q.offer(temp*2);
            q.offer(temp*3);
            q.offer(temp*5);
        }
        return q.poll().intValue();
    }
}
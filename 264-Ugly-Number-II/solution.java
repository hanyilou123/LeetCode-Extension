public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        q.add(1l);
        long temp=0;
        for(int i=1; i<n; i++)
        {
            temp = q.poll();
            while(!q.isEmpty() && q.peek()==temp)
                temp = q.poll();
            q.add(temp*2);
            q.add(temp*3);
            q.add(temp*5);
        }
        return temp;
    }
}
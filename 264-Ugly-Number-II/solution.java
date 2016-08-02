public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.offer(1l);
        int temp=0;
        for(int i=1; i<n; i++)
        {
            temp = q.poll();
            while(!q.isEmpty() && q.peek()==temp)
                temp = q.poll();
            q.offer(temp*2);
            q.offer(temp*3);
            q.offer(temp*5);
        }
        return temp;
    }
}
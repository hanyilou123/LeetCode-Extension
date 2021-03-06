public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s==null)
            return res;
        Queue<String> que = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        que.offer(s);
        visited.add(s);
        boolean found = false;
        int validLen = s.length();
        while(!que.isEmpty())
        {
            String cur = que.poll();
            if(found && cur.length()!=validLen)
                continue;
            if(isValid(cur))
            {
                res.add(cur);
                found = true;
                validLen = cur.length();
            }
            if(found)
                continue;
            for(int i=0; i<cur.length(); i++)
            {
                if(cur.charAt(i)!='(' && cur.charAt(i)!=')')
                    continue;
                String temp = cur.substring(0,i)+cur.substring(i+1);
                if(!visited.contains(temp))
                {
                    que.offer(temp);
                    visited.add(temp);
                }
            }
        }
        return res;
    }
    public boolean isValid(String str)
    {
        int count=0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='(')
                count++;
            if(str.charAt(i)==')')
                count--;
            if(count==-1)
                return false;
        }
        return count==0;
    }
}
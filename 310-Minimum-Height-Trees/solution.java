public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = ArrayList<Integer>();
        if(n==1)
        {
            res.add(0);
            return res;
        }
        List<Set<Integer>> neigh = new ArrayList<Set<Integer>>();
        for(int i=0; i<n; i++)
            neigh.add(new HashSet<Integer>());
        for(int i=0; i<edges.length; i++)
        {
            neigh.get(edges[i][0]).add(edges[i][1]);
            neigh.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0; i<n; i++)
        {
            if(neigh.get(i).size()==1)
                res.add(i);
        }
        while(n>2)
        {
            n -= res.size();
            List<Integer> newRes = new ArrayList<Integer>();
            for(Integer leave: res)
            {
                int temp = neigh.get(leave).iterator().next();
                neigh.get(temp).remove(leave);
                if(neigh.get(temp).size()==1)
                    newRes.add(temp);
            }
            res = newRes;
        }
        return res;
    }
}
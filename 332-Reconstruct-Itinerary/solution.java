public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<String, PriorityQueue<String>>();
        List<String> res = new ArrayList<String>();
        String from = "JFK";
        int len = tickets.length;
        for(int i=0; i<len; i++)
        {
            if(!ticketMap.containsKey(tickets[i][0]))
            {
                ticketMap.put(tickets[i][0], new PriorityQueue<String>());
            }
            ticketMap.get(tickets[i][0]).add(tickets[i][1]);
        }
        dfs(from, ticketMap, res);
        //Collections.reverse(res);
        return res;
    }
    public void dfs(String from, Map<String, PriorityQueue<String>> ticketMap, List<String> res)
    {
        while(ticketMap.containsKey(from) && !ticketMap.get(from).isEmpty())
        {
            dfs(ticketMap.get(from).poll(), ticketMap, res);
        }
        res.add(0, from);
    }
}
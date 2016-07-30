public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer,Integer>> que = new PriorityQueue<Map.Entry<Integer,Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>(){
                public int compare(Map.Entry<Integer,Integer>e1, Map.Entry<Integer, Integer>e2)
                {
                    return e1.getValue() - e2.getValue();
                }
            }
        );
        for(int i=0; i<nums.length; i++)
        {
            if(hash.containsKey(nums[i]))
            {
                int t = hash.get(nums[i]);
                hash.put(nums[i], t+1);
            }
            else
            {
                hash.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: hash.entrySet())
        {
            if(que.size()<k)
            {
                que.offer(entry);
            }
            else if(que.peek().getValue()<entry.getValue())
            {
                que.poll();
                que.offer(entry);
            }
        }
        for(Map.Entry<Integer, Integer> entry: que.entrySet())
        {
            res.add(entry.getKey());
        }
        return res;
    }
}
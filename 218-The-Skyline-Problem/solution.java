public class Solution {
    public class MaxHight implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b-a;
        }
    }
    public class ArrayCom implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0]!=b[0])
                return a[0]-b[0];
            else 
                return b[1]-a[1];
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        PriorityQueue<Integer> BigHeap = new PriorityQueue<Integer>(new ArrayCom());
        
        List<int[]> recordVer = new ArrayList<int[]>();
        for(int i=0; i<buildings.length; i++)
        {
            int[] temp = buildings[i];
            recordVer.add(new int[]{temp[0], temp[2]});
            recordVer.add(new int[]{temp[0], -temp[2]});
        }
        Collections.sort(recordVer, new MaxHight());
        int cur=0, pre=0;
        for(int i=0; i<recordVer.size(); i++)
        {
            int[] temp = recordVer.get(i);
            if(temp[1]>0)
            {
                BigHeap.offer(temp[1]);
                cur = BigHeap.peek();
            }
            else
            {
                BigHeap.remove(-temp[1]);
                cur = BigHeap.peek()==null?0:BigHeap.peek();
            }
            if(cur!=pre)
            {
                res.add(new int[]{temp[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}
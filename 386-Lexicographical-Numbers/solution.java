public class Solution {
    public class lexiComp implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            String aa = String.valueOf(a);
            String bb = String.valueOf(b);
            return aa.compareTo(bb);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=n; i++)
        {
            result.add(i);
        }
        Collections.sort(result, new lexiComp());
        return result;
    }
}
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int wd = 0;  //window
        for(int i=0; i<s.length(); i++)
        {
            wd = ((wd<<3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
            if(i<9)
                continue;
            if(hash.containsKey(wd))
            {
                if(hash.get(wd)==1)
                {
                    String sub = s.substring(i-9, i+1);
                    result.add(sub);
                    hash.put(wd,2);
                }
            }
            else{
                hash.put(wd, 1);
            }
        }
        return result;
    }
}
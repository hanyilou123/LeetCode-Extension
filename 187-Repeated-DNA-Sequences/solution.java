public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> hash = new HashMap<String, Integer>();
        for(int i=9; i<s.length(); i++)
        {
            String sub = s.substring(i-9, i+1); 
            if(hash.containsKey(sub))
            {
                if(hash.get(sub)==1)
                {
                    result.add(sub);
                    hash.put(sub,2);
                }
            }
            else{
                hash.put(sub, 1);
            }
        }
        return result;
    }
}
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null)
            return false;
        Map<Character, Integer> res1 = new HashMap<Character, Integer>();
        Map<Character, Integer> res2 = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++)
        {
            char c1 = s.charAt(i);
            if(res1.containsKey(c1))
            {
                int num = res1.get(c1);
                res1.put(c1, ++num);
            }
            else
                res1.put(c1, 1);
        }
        for(int i=0; i<t.length(); i++)
        {
            char c2 = t.charAt(i);
            if(res1.containsKey(c2))
            {
                int num = res1.get(c2);
                res1.put(c2, --num);
            }
            else{
                return false;
            }
        }
        for(Map.Entry<Character, Integer> entry: res1.entrySet())
        {
            if(entry.getValue()!=0)
                return false;
        }
        return true;
    }
}
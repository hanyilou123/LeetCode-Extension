public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null)
            return false;
        String[] splited = str.split(" ");
        char[] pat = pattern.toCharArray();
        Map<Character, String> hash = new HashMap<Character, String>();
        for(int i=0; i<pat.length; i++)
        {
            if(hash.containsKey(pat[i]))
            {
                if(!hash.get(pat[i]).equals(splited[i]))
                    return false;
            }
            else{
                hash.put(pat[i], splited[i]);
            }
        }
        return true;
    }
}
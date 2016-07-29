public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null)
            return false;
        String[] splited = str.split(" ");
        char[] pat = pattern.toCharArray();
        if(pat.length!=splited.length)
            return false;
        Map<Character, String> hash = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        for(int i=0; i<pat.length; i++)
        {
            if(hash.containsKey(pat[i]))
            {
                if(!hash.get(pat[i]).equals(splited[i]))
                    return false;
            }
            else{
                if(set.contains(splited[i]))
                    return false;
                hash.put(pat[i], splited[i]);
                set.add(splited[i]);
            }
        }
        return true;
    }
}
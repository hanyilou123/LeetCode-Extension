public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null)
            return false;
        if(s.length()!=t.length())
            return false;
        Map<Charater, Charater> map = new HashMap<Charater, Charater>();
        Set<Charater> set = new HashSet<Charater>();
        for(int i=0; i<s.length(); i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.containsKey(sc))
            {
                if(map.get(sc)!=tc)
                    return false;
            }
            else
            {
                if(set.contains(tc)) return false;
                else{
                    map.put(sc, tc);
                    set.add(tc);
                }
            }
        }
    }
}
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return breakProcess(s, wordDict, map);
    }
    public List<String> breakProcess(String s, Set<String> wordDict, Map<String, List<String>> map)
    {
        if(map.contains(s))
            return map.get(s);
        List<String> result = new ArrayList<String>();
        int n = s.length();
        if(s==null || n<=0)
            return result;
        for(int i=1; i<=n; i++)
        {
            String prefix = s.substring(0, i);
            if(wordDict.contains(prefix))
            {
                String subfix = s.substring(i);
                List<String> temp = breakProcess(subfix, wordDict, map);
                for(String str:temp)
                {
                    str = prefix + " " + str;
                    result.add(str);
                }
            }
        }
        map.add(s, result);
        return result;
    }
}
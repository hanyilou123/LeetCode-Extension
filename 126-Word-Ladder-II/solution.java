public class Solution {
    Map<String, Integer> pathDist = new HashMap<String, Integer>();
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        wordList.add(beginWord);
        wordList.add(endWord);
        bfs(beginWord, endWord, wordList, map);
        dfs(endWord, beginWord, wordList, path, result, map);
        return result;
    }
    
    public void bfs(String start, String end, Set<String> dict, Map<String, List<String>> map)
    {
        Queue<String> que = new LinkedList<String>();
        que.offer(start);
        pathDist.put(start, 0);
        for(String s: dict)
        {
            map.put(s, new ArrayList<String>());
        }
        while(!que.isEmpty())
        {
            String cur = que.poll();
            if(cur.equals(end))
                continue;
            for(int i=0; i<cur.length(); i++)
            {
                char[] curArray = cur.toCharArray();
                for(char ch='a'; ch<='z'; ch++)
                {
                    if(curArray[i]==ch)
                        continue;
                    curArray[i]=ch;
                    String newCur = new String(curArray);
                    if(dict.contains(newCur))
                    {
                        map.get(newCur).add(cur);
                        if(!pathDist.containsKey(newCur))    //!pathDist.containsKey(newCur);
                        {
                            int depth = pathDist.get(cur);
                            pathDist.put(newCur, depth+1);
                            que.add(newCur);
                        }
                    }
                }
            }
        }
    }
    
    public void dfs(String start, String end, Set<String> dict, List<String> path, List<List<String>> result, Map<String, List<String>> map)
    {
        path.add(start);
        if(start.equals(end))
        {
            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            Collections.reverse(path);
        }
        else{
            for(String next: map.get(start))
            {
                if(pathDist.containsKey(next) && pathDist.get(next)+1==pathDist.get(start))
                    dfs(next, end, dict, path, result, map);
            }
        }
        path.remove(path.size()-1);
    }
}
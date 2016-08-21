public class Solution {
    Map<String, Integer> pathDist = new HashMap<String, Integer>();
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        bfs(beginWord, endWord, wordList);
        dfs(endWord, beginWord, wordList, path, result);
        return result;
    }
    
    public void bfs(String start, String end, Set<String> dict)
    {
        Queue<String> que = new LinkedList<String>();
        que.offer(start);
        pathDist.put(start, 0);
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
                    if(dict.contains(newCur) || newCur.equals(end))
                    {
                        if(pathDist.get(newCur)==null)    //pathDist.containsKey(newCur);
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
    
    public void dfs(String start, String end, Set<String> dict, List<String> path, List<List<String>> result)
    {
        if(start.equals(end))
        {
            path.add(start);
            Collections.reverse(path);
            result.add(path);
            return;
        }
        if(pathDist.get(start)==null)
            return;
        path.add(start);
        int nextDist = pathDist.get(start)-1;
        for(int i=0; i<start.length(); i++)
        {
            char[] curArray = cur.toCharArray();
            for(char ch='a'; ch<='z'; ch++)
            {
                if(curArray[i]==ch)
                    continue;
                curArray[i]=ch;
                String newCur = new String(curArray);
                if(pathDist.get(newCur)!=null && pathDist.get(newCur)==nextDist)
                {
                    dfs(newCur, end, dict, path, result);
                }
            }
        }
    }
}
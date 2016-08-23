public class Solution {
    List<String> result = new ArrayList<String>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String str: words)
        {
            trie.insert(str);
        }
        int m = board.length;
        int n = board[0].length;
        boolea[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                dfs(i, j, "", board, trie, visited);
            }
        }
        return result;
    }
    public void dfs(int i, int j, String str, char[][] board, Trie trie, boolea[][] visited)
    {
        str += board[i][j];
        if(!trie.startsWith(str))
            return;
        if(trie.search(str))
            result.add(str);
        int m=board.length, n=board[0].length;
        visited[i][j]=true;
        for(int k=0; k<dx.length; k++)
        {
            if(i+dx[k]>=0 && i+dx[k]<m && j+dy[k]>=0 && j+dy[k]<n && !visited[i][j])
            {
                dfs(i+dx[k], j+dy[k], str, board, trie, visited);
            }
        }
        visited[i][j]=false;
    }
}
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String item = "";
    public TrieNode(){
        
    }
}
class Trie{
    TrieNode root;
    public Trie()
    {
        root = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode node = root;
        for(char c: word.toCharArray())
        {
            if(node.children[c-'a']==null)
            {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }
    public boolean search(String word)
    {
        TrieNode node = root;
        for(char c: word.toCharArray())
        {
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return node.item.equals(word);
    }
    public boolean startsWith(String prefix)
    {
        TrieNode node = root;
        for(char c:prefix.toCharArray())
        {
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
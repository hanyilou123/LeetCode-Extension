public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList==null)
            return 0;
        if(beginWord.equals(endWord))
            return 1;
        wordList.add(beginWord);
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        Set<String> hash = new HashSet<String>();
        queue.offer(beginWord);
        hash.add(beginWord);
        int length = 1;
        while(!queue.isEmpty())
        {
            length++;
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                String word = queue.poll();
                for(String nextword: getNextWord(word, wordList))
                {
                    if(hash.contains(nextword))
                        continue;
                    if(nextword.equals(endWord))
                        return length;
                    hash.add(nextword);
                    queue.offer(nextword);
                }
            }
        }
        return 0;
    }
    public ArrayList<String> getNextWord(String word, Set<String> wordList)
    {
        ArrayList<String> nextWordList = new ArrayList<String>();
        for(char c='a'; c<='z'; c++)
        {
            for(int i=0; i<word.length(); i++)
            {
                if(word.charAt(i)==c)
                    continue;
                String nextword = replaceChar(word, i, c);
                if(wordList.contains(nextword))
                    nextWordList.add(nextword);
            }
        }
        return nextWordList;
    }
    public String replaceChar(String word, int index, char c)
    {
        char[] newString = word.toCharArray();
        newString[index] = c;
        return new String(newString);
    }
}
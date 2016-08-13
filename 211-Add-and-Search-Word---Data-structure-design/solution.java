public class WordDictionary {
    Map<Integer, List<String>> dic = new HashMap<Integer, List<String>>();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        int len = word.length();
        if(dic.containsKey(len))
        {
            dic.get(len).add(word);
        }
        else
        {
            List<String> temp = new ArrayList<String>();
            temp.add(word);
            dic.put(len, temp);
        }
        this.dic=dic;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int len = word.length();
        if(!dic.containsKey(len))
        {
            return false;
        }
        else
        {
            List<String> words = dic.get(len);
            for(String s:words)
            {
                if(isSame(s, word))
                    return true;
            }
            return false;
        }
    }
    
    public boolean isSame(String a, String b)
    {
        int i=0;
        while(i<a.length())
        {
            if(b.charAt(i)!='.' && b.charAt(i)!=a.charAt(i))
            {
                return false;
            }
            i++;
        }
        return true;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
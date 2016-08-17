public class Solution {
    public class compLen implements Comparator<String>{
        public int compare(String a, String b)
        {
            return b.length()-a.length();
        }
    }
    public int maxProduct(String[] words) {
        if(words==null || words.length==0)
            return 0;
        int len = words.length;
        int[] bitmap = new int[len];
        Arrays.sort(words, new compLen());
        for(int i=0; i<len; i++)
        {
            for(char c: words[i].toCharArray())
            {
                bitmap[i] |= 1<<(c-'a');
            }
        }
        int max=0;
        for(int i=0; i<len; i++)
        {
            if(words[i].length()*words[i].length()<max)
                break;
            for(int j=i+1; j<len; j++)
            {
                if((words[i]&words[j])==0)
                {
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
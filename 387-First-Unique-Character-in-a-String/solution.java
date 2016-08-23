public class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0)
            return -1;
        int[] letters = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            letters[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++)
        {
            if(letters[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
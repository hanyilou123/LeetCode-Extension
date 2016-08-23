public class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0)
            return -1;
        int[] letters = new int[26];
        int loc = -1;
        for(int i=0; i<s.length(); i++)
        {
            letters[s.charAt(i)-'a')]++;
        }
        for(int i=0; i<26; i++)
        {
            if(letters[i]==1)
                loc = i;
        }
        if(loc!=-1)
            return s.indexOf('a'+loc);
        else 
            return loc;
    }
}
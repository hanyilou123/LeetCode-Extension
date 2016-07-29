public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null)
            return false;
        int[] model = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            char c1 = s.charAt(i);
            model[c1-'a']++;
        }
        for(int i=0; i<t.length(); i++)
        {
            char c2 = t.charAt(i);
            model[c2-'a']--;
        }
        for(int i=0; i<26; i++)
        {
            if(model[i]!=0)
                return false;
        }
        return true;
    }
}
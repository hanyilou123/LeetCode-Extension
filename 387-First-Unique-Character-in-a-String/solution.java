public class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0)
            return -1;
        int[] letters = new int[26];
        char[] sToArray = s.toCharArray();
        for(int i=0; i<sToArray.length; i++)
        {
            letters[sToArray[i]-'a']++;
        }
        for(int i=0; i<sToArray.length; i++)
        {
            if(letters[sToArray[i]-'a']==1)
                return i;
        }
        return -1;
    }
}
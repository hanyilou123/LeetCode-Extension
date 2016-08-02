public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        char[] alpha = new char[26];
        for(int i=0; i<26; i++)
            alpha[i] = (char)('A'+i);
        int i=0;
        while(i<(n/27))
        {
            res+="A";
        }
        res += alpha[n%26-1];
        return res;
    }
}
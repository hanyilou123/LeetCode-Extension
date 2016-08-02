public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        char[] alpha = new char[26];
        for(int i=0; i<26; i++)
            alpha[i] = (char)('A'+i);
        int i=0;
        if(n>26)
        {
            while(i<(n/27))
            {
                res+="A";
                i++;
            }
            res += alpha[n%26-1];
        }
        else
            res += alpha[n-1];
        return res;
    }
}
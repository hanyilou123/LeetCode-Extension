public class Solution {
    public String getHint(String secret, String guess) {
        int[] model = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int bull=0, cow=0;
        for(int i=0; i<s.length; i++)
        {
            model[s[i]-'0']++;
        }
        for(int i=0; i<g.length; i++)
        {
            if(g[i]==s[i])
                bull++;
            else if(model[g[i]-'0']>0)
                cow++;
            model[g[i]-'0']--;
        }
        String result = boll+"A"+cow+"B";
        return result;
    }
}
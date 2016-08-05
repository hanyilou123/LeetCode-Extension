public class Solution {
    int start=0, maxlen=0;
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            process(s, i, i);     //assume odd length
            process(s, i, i+1);   //assume even length
        }
        return s.substring(start, start+maxlen);
    }
    public void process(String str, int s, int e)
    {
        if(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e))
        {
            s--;
            e++;
        }
        if(maxlen<e-s-1)
        {
            start = s++;
            maxlen = e-s-1;
        }
    }
}
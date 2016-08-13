public class Solution {
    public boolean isMatch(String s, String p) {
        int si=0, pi=0, match=0, startIdx=-1;
        while(si<s.length())
        {
            if(pi<p.length() && ((p.charAt(pi)=='?') || (p.charAt(pi)==s.charAt(si))))
            {
                pi++;
                si++;
            }
            else if(pi<p.length() && p.charAt(pi)=='*')
            {
                startIdx = pi;
                match = si;
                pi++;
            }
            else if(startIdx!=-1)
            {
                pi = startIdx+1;
                match++;
                si = match;
            }
            else 
                return false;
        }
        while(pi<p.length() && p.charAt(pi)=='*')
            pi++;
        return pi==p.length();
    }
}
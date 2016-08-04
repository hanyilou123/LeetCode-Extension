public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1)
            return true;
        int i=0, j=s.length()-1;
        while(i<j)
        {
            while(i<s.length() && i<j && (s.charAt(i)<'A' || (s.charAt(i)>'Z' && s.charAt(i)<'a') || s.charAt(i)>'z'))
                i++;
            if(i==s.length())
                return true;
            while(j>=0 && i<j && (s.charAt(j)<'A' || (s.charAt(j)>'Z' && s.charAt(j)<'a') || s.charAt(j)>'z'))
                j--;
            if(s.charAt(i)==s.charAt(j) || s.charAt(i)==(char)(s.charAt(j)+32) || s.charAt(i)==(char)(s.charAt(j)-32))
                continue;
            else
                return false;
        }
        return true;
    }
}
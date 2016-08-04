public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1)
            return true;
        int i=0, j=s.length()-1;
        while(i<j)
        {
            while(i<s.length() && !isValid(s.charAt(i)))
                i++;
            if(i==s.length())
                return true;
            while(j>=0 && !isValid(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
            {
                break;
            }
            else
            {
                i++;
                j--;
            }
        }
        return j<=i;
    }
    public boolean isValid(char c)
    {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
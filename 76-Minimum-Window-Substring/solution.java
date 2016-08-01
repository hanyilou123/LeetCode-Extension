public class Solution {
    public boolean isValid(int[] source, int[] target)
    {
        for(int i=0; i<256; i++)
        {
            if(target[i]>source[i])
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s==null || t==null || t.length()>s.length())
            return "";
        int ls = s.length(), lt = t.length(), minlen=Integer.MAX_VALUE, start=0;
        int[] source = new int[256];
        int[] target = new int[256];
        String minStr = "";
        for(char c: t.toCharArray())
        {
            target[c]++;
        }
        int i=0, j=0;
        for(i=0; i<ls; i++)
        {
            while(!isValid(source, target) && j<ls)
            {
                source[s.charAt(j)]++;
                if(j<ls)
                    j++;
                else
                    break;
            }
            if(isValid(source, target))
            {
                if(j-i<minlen)
                {
                    minlen = Math.min(minlen, j-i);
                    minStr = s.substring(i, j);
                }
            }
            source[s.charAt(i)]--;
        }
        return minStr;
    }
}
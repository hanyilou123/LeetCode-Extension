public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;
        int len = s.length();
        int[] result = new int[len+1];
        result[len] = 1;
        result[len-1] = s.charAt(len-1)=='0'?0:1;
        
        for(int i=len-2; i>=0; i--)
        {
            if(s.charAt(i)=='0')
                continue;
            else
                result[i] = (Integer.parseInt(s.substring(i, i+2))<=26)? result[i+1]+result[i+2]: result[i+1];
        }
        return result[0];
    }
}
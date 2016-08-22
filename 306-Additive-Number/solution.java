public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num==null || num.length()<2)
            return false;
        int len = num.length();
        for(int i=1; i<=len/2; i++)
        {
            for(int j=1; Math.max(i, j)<=len-i-j; j++)
            {
                if(isValid(i, j, num))
                    return true;
            }
        }
        return false;
    }
    public boolean isValid(int i, int j, String num)
    {
        if(num.charAt(i)=='0' && j>1)
            return false;
        if(num.charAt(0)=='0' && i>1)
            return false;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i+j));
        String sum = "";
        for(int k=i+j; k<num.length(); k+=sum.length())
        {
            x2 = x1+x2;
            x1 = x2-x1;
            sum = String.valueOf(x2);
            if(!num.startsWith(sum, k))
                return false;
        }
        return true;
    }
}
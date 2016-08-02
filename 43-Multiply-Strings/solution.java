public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null || num2==null)
            return null;
        int len1=num1.length(), len2=num2.length(), len3=len1+len2;
        int[] num3 = new int[len3];
        int carry=0, product=0, i=0, j=0;
        for(i=len1-1; i>=0; i--)
        {
            carry=0;
            for(j=len2-1; j>=0; j--)
            {
                product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + carry + num3[i+j+1];
                num3[i+j+1] = product%10;
                carry = product/10;
            }
            num3[i+j+1]=carry;
        }
        String result = "";
        int index=0;
        while(index<len3-1 && num3[index]==0)
            index++;
        while(index<len3)
        {
            result += (char)(num3[index++]+'0');
        }
        return result;
    }
}
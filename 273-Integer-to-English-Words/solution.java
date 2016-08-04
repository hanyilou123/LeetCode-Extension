public class Solution {
    String[] lessThan20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        String result="";
        int index=0;
        while(num>0)
        {
            if(num%1000 !=0)
                result = helper(num%1000) + thousands[index] + " " + result;
            num /=1000;
            index++;
        }
        return result.trim();
    }
    public String helper(int n)
    {
        if(n==0)
            return "";
        else if(n<20)
        {
            return lessThan20[n]+" ";
        }
        else if(n<100)
        {
            return tens[n/10]+" "+helper(n%10);
        }
        else
            return lessThan20[n/100] + " Hundred " + helper(n%100);
    }
}
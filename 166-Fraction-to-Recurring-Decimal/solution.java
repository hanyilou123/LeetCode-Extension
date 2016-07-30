public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)
            return "0";
        if(denominator==0)
            return "";
        String res = "";
        if((numerator>0) ^ (denominator>0))
        {
            res+="-";
        }
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(num);
        res += num/den;
        
        int rem = num%den*10;
        if(rem==0)
            return res;
        else
            res+=".";
            
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        while(rem!=0)
        {
            int quo = rem/den;
            if(hash.containsKey(quo))
            {
                int start = hash.get(quo);
                String part1 = res.substring(0,start);
                String part2 = res.substring(start, res.length());
                res = part1+"("+part2+")";
                return res;
            }
            else
            {
                hash.put(quo, res.length());
                res += quo;
                rem = rem%den*10;
            }
        }
        return res;
    }
}
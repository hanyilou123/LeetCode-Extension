public class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        int result=0;
        int sum = getInt(s.charAt(0));
        int last = sum;
        for(int i=1; i<s.length(); i++)
        {
            int cur = getInt(s.charAt(i));
            if(cur==last)
            {
                sum += cur;
            }
            else if(cur<last)
            {
                result+=sum;
                sum = cur;
            }
            else{
                sum = cur-sum;
            }
            last = cur;
        }
        result += sum;
        return result;
    }
    public int getInt(char c)
    {
        switch(c){
            case 'I': return 1;
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000; 
            default : return 0;
        }
    }
}
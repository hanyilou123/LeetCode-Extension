public class Solution {
    public boolean isUgly(int num) {
        if(num==1)
            return true;
        while(nums>1)
        {
            if(nums%2==0)
                nums /= 2;
            else if(nums%3==0)
                nums /= 3;
            else if(nums%5==0)
                nums /= 5;
            else
                return false;
        }
        return true;
    }
}
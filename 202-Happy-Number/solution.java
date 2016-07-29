public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<Integer>();
        while(n!=1)
        {
            if(hash.contains(n))
                return false;
            hash.add(n);
            n = getNext(n);
        }
        return true;
    }
    public int getNext(int num)
    {
        int total = 0;
        while(num!=0)
        {
            int h = num%10;
            total += h*h;
            num /= 10;
        }
        return total;
    }
}
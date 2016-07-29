public class Solution {
    public int countPrimes(int n) {
        if(n<=1)
            return 0;
        int count=0;
        boolean[] isPrimes = new boolean[n];
        for(int i=2; i<n; i++)
        {
            isPrimes[i] = true;
        }
        for(int i=2; i*i<n; i++)
        {
            if(!isPrimes[i])
                continue;
            for(int j=i*i; j<n; j+=i)
            {
                isPrimes[j] = false;
            }
        }
        for(int i=2; i<n; i++)
        {
            if(isPrimes[i])
                count++;
        }
        return count;
    }
}
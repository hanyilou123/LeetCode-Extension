public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1)
            return 1;
        int[] result = new int[n];
        int[] indices = new int[primes.length];
        result[0]=1;
        for(int i=1; i<n; i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++)
            {
                if(primes[j]*result[indices[j]]<min)
                {
                    min = primes[j]*result[indices[j]];
                }
            }
            result[i] = min;
            for(int j=0; j<primes.length; j++)
            {
                while(primes[j]*result[indices[j]]<=result[i])
                    indices[j]++;
            }
        }
        return result[n-1];
    }
}
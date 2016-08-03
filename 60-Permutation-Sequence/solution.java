public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        int[] factor = new int[n+1];
        factor[0]=1;
        int pro=1;
        for(int i=1; i<=n; i++)
        {
            pro *= i;
            factor[i] = pro;
            nums.add(i);
        }
        k--;
        for(int i=1; i<=n; i++)
        {
            int index = k/factor[n-i];
            sb.append(String.valueOf(nums.get(index)));
            nums.remove(index);
            k-=index*factor[n-1];
        }
        return sb.toString();
    }
}
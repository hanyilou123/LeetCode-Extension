public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0)
            return new int[2];
        int idx1=0, idx2=numbers.length-1;
        int[] res = new int[2];
        while(idx1<idx2)
        {
            if(numbers[idx1]+numbers[idx2]==target)
                break;
            else if(numbers[idx1]+numbers[idx2]>target)
                idx2--;
            else
                idx1++;
        }
        res[0] = idx1+1;
        res[1] = idx2+1;
        return res;
    }
}
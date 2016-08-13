public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(k==0)
            return new int[0];
        int m=nums1.length, n=nums2.length;
        if(m+n<k)
            return null;
        else if(m+n==k)
        {
            int[] result = merge(nums1, nums2, k);
            return result;
        }
        else
        {
            int maxM = m>=k?k:m;
            int minM = n>=k?0:k-n;
            int[] result = new int[k];
            for(int i=0; i<k; i++)
                result[i]=Integer.MIN_VALUE;
            for(int i=minM; i<=maxM; i++)
            {
                int[] temp = merge(getMaxK(nums1, i), getMaxK(nums2, k-i), k);
                result = isGreater(result, 0, temp, 0)?result:temp;
            }
            return result;
        }
    }
    public int[] merge(int[] nums1, int[] nums2, int k)
    {
        int[] result = new int[k];
        if(k==0)
            return result;
        int i=0, j=0;
        for(int l=0; l<k; l++)
        {
            result[l] = isGreater(nums1, i, nums2, j)?nums1[i++]:nums2[j++];
        }
        return result;
    }
    public boolean isGreater(int[] nums1, int i, int[] nums2, int j)
    {
        for(; i<nums1.length && j<nums2.length; i++, j++)
        {
            if(nums1[i]>nums2[j])
                return true;
            if(nums1[i]<nums2[j])
                return false;
        }
        return i!=nums1.length;
    }
    public int[] getMaxK(int[] nums, int k)
    {
        if(k==0)
            return new int[0];
        int[] result = new int[k];
        int i=0;
        for(int j=0; j<nums.length; j++)
        {
            while(nums.length-j>k-i && i>0 && result[i-1]<nums[j])
                i--;
            if(i<k)
                result[i++]=nums[j];
        }
        // int[] temp = nums;
        // Arrays.sort(temp);
        // int j=0;
        // for(int i=temp.length-1; i>=temp.length-k; i--)
        //     result[j++] = temp[i];
        // return result;
    }
}
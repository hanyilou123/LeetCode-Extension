public class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int start=0, end=height.length-1, area=0, smaller=0;
        while(start<end)
        {
            if(height[start]<height[end])
            {
                smaller = height[start];
                while(start<end && height[start]<=smaller)
                {
                    area += smaller - height[start];
                    start++;
                }
            }
            else
            {
                smaller = height[end];
                while(start<end && height[end]<=smaller)
                {
                    area += smaller - height[end];
                    end--;
                }
            }
        }
        return area;
    }
}
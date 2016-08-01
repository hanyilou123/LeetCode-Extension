/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length<3)
            return points.length;
        Map<Double, Integer> hash = new HashMap<Double, Integer>();
        int maxP = 0;
        for(int i=0; i<points.length; i++)
        {
            hash.clear();
            int dup = 1;
            for(int j=0; j<points.length; j++)
            {
                if(i==j)
                    continue;
                double slope = 0.0;
                if(points[j].x==points.[i].x && points[j].y==points[i].y)
                {
                    dup++
                    continue;
                }
                else if(points[j].x==points.[i].x)
                {
                    slope = Integer.MAX_VALUE;
                }
                else{
                    slope = 1.0*(points[j].x-points[i].x)/(points[j].y-points[i].y);
                }
                hash.put(slope, hash.containsKey(slope)?hash.get(slope)+1:1);
            }
            if(hash.size()==0)
            {
                maxP = dup>maxP? dup:maxP;
            }
            else
            {
                for(double key: hash.keySet())
                {
                    maxP = Math.max(maxP, dup+hash.get(key));
                }
            }
        }
        return maxP;
    }
}
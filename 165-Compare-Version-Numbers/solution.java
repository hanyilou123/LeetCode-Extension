public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int len = Math.max(a1.length, a2.length);
        for(int i=0; i<len; i++)
        {
            int part1 = i<a1.length? Integer.parseInt(a1[i]):0;
            int part2 = i<a2.length? Integer.parseInt(a2[i]):0;
            int diff = part1-part2;
            if(diff==0)
                continue;
            else if(diff>0)
                return 1;
            else
                return -1;
        }
        return 0;
    }
}
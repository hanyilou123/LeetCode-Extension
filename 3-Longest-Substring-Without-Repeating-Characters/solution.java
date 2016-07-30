public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length==0)
            return 0;
        Set<Character> hash = new HashSet<Character>();
        int start=0, end=0, maxlen=0;
        for(int i=0; i<s.length(); i++)
        {
            if(hash.contains(s.charAt(i)))
            {
                maxlen = Math.max(maxlen, end-start);
                start=end=i;
                hash.clear();
                hash.add(s.charAt(i));
            }
            else{
                hash.add(s.charAt(i));
                end++;
            }
        }
        return maxlen;
    }
}
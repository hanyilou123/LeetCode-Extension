public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        Set<Character> hash = new HashSet<Character>();
        int start=0, maxlen=0;
        for(int i=0; i<s.length(); i++)
        {
            if(hash.contains(s.charAt(i)))
            {
               while(start<i && s.charAt(start)!=s.charAt(i))
               {
                   hash.remove(s.charAt(start));
                   start++;
               }
               start++;
            }
            else{
                maxlen = Math.max(maxlen, i-start+1);
                hash.add(s.charAt(i));
            }
        }
        return maxlen;
    }
}
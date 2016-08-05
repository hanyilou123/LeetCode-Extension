public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
            return s;
        String[] splitStr = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=splitStr.length-1; i>=0; i--)
        {
            sb.append(splitStr[i]+" ");
        }
        return sb.toString().trim();
        // String[] words = s.trim().split(" +");
        // Collections.reverse(Arrays.asList(words));
        // return String.join(" ", words);
    }
}
public class Solution {
    public String reverseWords(String s) {
        // if(s==null || s.length()==0)
        //     return s;
        // s=s.trim();
        // String[] splitStr = s.split(" ");
        // StringBuilder sb = new StringBuilder();
        // for(int i=splitStr.length-1; i>=0; i--)
        // {
        //     if(!splitStr[i].equals(""))
        //         sb.append(splitStr[i]+" ");
        // }
        // return sb.toString().trim();
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
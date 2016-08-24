public class Solution {
    public int lengthLongestPath(String input) {
        String[] splitArr = input.split("\n");
        int maxlen=0, curlen=0;
        Stack<Integer> lenStk = new Stack<Integer>();
        for(String str:splitArr)
        {
            int level = countLevel(str);
            if(lenStk.size()>level)
            {
                curlen -= lenStk.pop();
            }
            int len = str.replaceAll("\t", "").length()+1;
            curlen +=len;
            if(str.contains("."))
            {
                maxlen = Math.max(maxlen, curlen-1);
            }
            lenStk.push(len);
        }
    }
    public int countLevel(String str)
    {
        String newStr = str.replaceAll("\t", "");
        return str.length() - newStr.length();
    }
}
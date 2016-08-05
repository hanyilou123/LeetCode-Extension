public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backTrack(result, 0, 0, "", n);
        return result;
    }
    public backTrack(List<String> result, int open, int close, String str, int max)
    {
        if(str.length()==max)
        {
            result.add(str);
            return;
        }
        if(open<max)
            backTrack(result, open+1, close, str+'(', max);
        if(close<open)
            backTrack(result, open, close+1, str+')', max);
    }
}
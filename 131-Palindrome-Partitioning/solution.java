public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> row = new ArrayList<String>();
        if(s==null || s.length()==0)
            return result;
        partProcess(result, row, s);
        return result;
    }
    public void partProcess(List<List<String>> result, List<String> row, String s)
    {
        if(s.length()==0)
        {
            result.add(row);
        }
        for(int i=1; i<=s.length(); i++)
        {
            String prefix = s.substring(0, i);
            if(isPalindrome(prefix))
            {
                row.add(prefix);
                String subfix = s.substring(i);
                partProcess(result, row, s);
                row.remove(row.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str)
    {
        int i=0, j=str.length()-1;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
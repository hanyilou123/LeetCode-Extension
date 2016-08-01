public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(words==null || words.length==0)
            return result;
        for(int i=0; i<words.length; i++)
        {
            for(int j=0; j<words.length; j++)
            {
                if(i!=j)
                {
                    String temp = ""+words[i]+word[j];
                    List<Integer> group = new ArrayList<Integer>();
                    if(isPalindrome(temp))
                    {
                        group.add(i);
                        group.add(j);
                        result.add(group);
                    }
                }
            }
        }
    }
    public boolean isPalindrome(String str)
    {
        int len = str.length();
        for(int i=0; i<len/2; i++)
        {
            if(str.charAt(i)!=str.charAt(len-i-1))
                return false;
        }
        return true;
    }
}
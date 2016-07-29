public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs==null)
            return result;
        int len = strs.length;
        int[] flag = new int[len];
        for(int i=0; i<len; i++)
        {
            if(flag[i]==0)
            {
                List<String> row = new ArrayList<String>();
                row.add(strs[i]);
                flag[i]=1;
                Set<Character> ana = new HashSet<Character>();
                for(int j=0; j<strs[i].length(); j++)
                {
                    ana.add(strs[i].charAt(j));
                }
                for(int j=i; j<len; j++)
                {
                    if(flag[j]==0)
                    {
                        int k = 0;
                        for(k=0; k<strs[j].length(); k++)
                        {
                            if(!ana.contains(strs[j].charAt(k)))
                                break;
                        }
                        if(k==strs[j].length())
                        {
                            row.add(strs[j]);
                            flag[j]=1;
                        }
                    }
                }
            }
            result.add(row);
        }
        return result;
    }
}
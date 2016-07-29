public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs==null)
            return result;
        int len = strs.length;
        int[] flag = new int[len];
        List<String> nullrow = new ArrayList<String>();
        for(int i=0; i<len; i++)
        {
            if(strs[i].equals(""))
            {
                nullrow.add(strs[i]);
                flag[i]=1;
            }
        }
        if(nullrow)
            result.add(nullrow);
        
        for(int i=0; i<len; i++)
        {
            if(flag[i]==0)
            {
                List<String> row = new ArrayList<String>();
                row.add(strs[i]);
                flag[i]=1;
                for(int j=i+1; j<len; j++)
                {
                    if(flag[j]==0)
                    {
                        int[] model = new int[26]; 
                        for(int l=0; l<strs[i].length(); l++)
                        {
                            model[strs[i].charAt(l)-'a']++;
                        }
                        for(int k=0; k<strs[j].length(); k++)
                        {
                            model[strs[j].charAt(k)-'a']--;
                        }
                        int index=0;
                        for(index=0; index<26; index++)
                        {
                            if(model[index]!=0)
                                break;
                        }
                        if(index==26)
                        {
                            row.add(strs[j]);
                            flag[j]=1;
                        }
                    }
                }
                result.add(row);
            }
        }
        return result;
    }
}
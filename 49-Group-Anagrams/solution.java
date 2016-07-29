public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs==null)
            return result;
        int len = strs.length;
            
        Map<String, ArrayList<String>> map1 = new HashMap<String, ArrayList<String>>();
        for(int i=0; i<len; i++)
        {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String newStr = new String(temp);
            if(map1.containsKey(newStr))
                map1.get(newStr).add(strs[i]);
            else
            {
                ArrayList<String> valList = new ArrayList<String>();
                valList.add(strs[i]);
                map1.put(newStr, valList);
            }
        }
        for(Map.Entry<String, ArrayList<String>> entry: map1.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }
}
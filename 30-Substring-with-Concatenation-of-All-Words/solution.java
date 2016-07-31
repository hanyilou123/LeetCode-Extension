public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> model = new HashMap<String, Integer>();
        Map<String, Integer> found = new HashMap<String, Integer>();
        int size = words.length, len = words[0].length();
        for(int i=0; i<size; i++)
        {
            if(model.containsKey(words[i]))
                model.put(words[i], model.get(words[i])+1);
            else
                model.put(words[i], 1);
        }
        for(int i=0; i<=s.length()-size*len; i++)
        {
            found.clear();
            int j=0;
            for(j=0; j<size; j++)
            {
                int k = i+j*len;
                String sub = s.substring(k ,k+len);
                if(!model.containsKey(sub))
                    break;
                if(found.containsKey(sub))
                {
                    found.put(sub, found.get(sub)+1)
                }
                else{
                    found.put(sub, 1);
                }
                if(found.get(sub)>model.get(sub))
                    break;
            }
            if(j==size)
                result.add(i);
        }
        return result;
    }
}
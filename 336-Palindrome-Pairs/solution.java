public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(words==null || words.length==0)
            return result;
        Map<String, Integer> hash = new HashMap<String, Integer>();
        List<Integer> wp = new ArrayList<Integer>();
        for(int i=0; i<words.length; i++)
        {
            hash.put(words[i], i);
            if(!words[i].equals("") && isPalindrome(words[i]))
                wp.add(i);
        }
        
        for(int i=0; i<words.length; i++)
        {
            if(words[i].equals(""))
            {
                for(int index: wp)
                {
                    List<Integer> temp1 = new ArrayList<Integer>();
                    temp1.add(i);
                    temp1.add(index);
                    result.add(temp1);
                    List<Integer> temp2 = new ArrayList<Integer>();
                    temp2.add(index);
                    temp2.add(i);
                    result.add(temp2);
                }
            }
            
            for(int j=0; j<words[i].length(); j++)
            {
                String part1 = words[i].substring(0, j);
                String part2 = words[i].substring(j, words[i].length());
                String reverse1 = reverseStr(part1);
                String reverse2 = reverseStr(part2);
                if(isPalindrome(part1) && hash.containsKey(reverse2) && !reverse2.equals(""))
                {
                    List<Integer> comp1 = new ArrayList<Integer>();
                    if(hash.get(reverse2)!=i)
                    {
                        comp1.add(hash.get(reverse2));
                        comp1.add(i);
                        result.add(comp1);
                    }
                }
                if(isPalindrome(part2) && hash.containsKey(reverse1) && !reverse1.equals(""))
                {
                    List<Integer> comp2 = new ArrayList<Integer>();
                    if(hash.get(reverse1)!=i)
                    {
                        comp2.add(i);
                        comp2.add(hash.get(reverse1));
                        result.add(comp2);
                    }
                }
            }
        }
        return result;
    }
    public String reverseStr(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public boolean isPalindrome(String str)
    {
        // int len = str.length();
        // for(int i=0; i<len/2; i++)
        // {
        //     if(str.charAt(i)!=str.charAt(len-i-1))
        //         return false;
        // }
        // return true;
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
public class Solution {
    public String simplifyPath(String path) {
        String result = "/";
        String[] splitStr = path.split("/");
        List<String> temp = new ArrayList<String>();
        
        for(String s: splitStr)
        {
            if(s.equals(".."))
            {
                if(temp.size()>0)
                {
                    temp.remove(temp.size()-1);
                }
            }
            else if(!s.equals(".") && !s.equals(""))
            {
                temp.add(s);
            }
        }
        for(String s:temp)
        {
            result += s + "/";
        }
        if(result.length()>1)
            return result.substring(0, result.length()-1);
        return result;
    }
}
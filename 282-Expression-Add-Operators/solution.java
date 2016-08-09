public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rest = new ArrayList<String>();
        if(num==null || num.length()==0)
            return rest;
        helper(rest, num, "", target, 0, 0, 0);
        return rest;
    }
    public void helper(List<String> rest, String num, String path, int target, int pos, long curRes, long preNum)
    {
        if(pos==num.length() && curRes==target)
            rest.add(path);
        for(int i=pos; i<num.length(); i++)
        {
            if(i!=pos && num.charAt(pos)=='0')
                break;
            long curNum = Long.parseLong(num.substring(pos, i+1));
            if(pos==0)
            {
                helper(rest, num, path+curNum, target, i+1, curNum, curNum);
            }
            else{
                helper(rest, num, path+"+"+curNum, target, i+1, curRes+curNum, curNum);
                helper(rest, num, path+"-"+curNum, target, i+1, curRes-curNum, -curNum);
                helper(rest, num, path+"*"+curNum, target, i+1, curRes-preNum+preNum*curNum, preNum*curNum);
            }
        }
    }
}
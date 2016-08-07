public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<input.length(); i++)
        {
            if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='/')
            {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i);
                List<Integer> r1 = diffWaysToCompute(part1);
                List<Integer> r2 = diffWaysToCompute(part2);
                for(Integer p1: r1)
                {
                    for(Integer p2:r2)
                    {
                        char c = input.charAt(i);
                        int tot = 0;
                        if(c=='+')
                            tot = p1+p2;
                        else if(c=='-')
                            tot = p1-p2;
                        else
                            tot = p1*p2;
                        res.add(tot);
                    }
                }
            }
        }
        if(res.size()==0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
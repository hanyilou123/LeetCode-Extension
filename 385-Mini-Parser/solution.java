/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if(!s.startsWith("["))
            return new NestedInteger(Integer.parseInt(s));
        Stack<NestedInteger> stk = new Stack<NestedInteger>();
        NestedInteger res = new NestedInteger();
        stk.push(res);
        int start=1;
        for(int i=1; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='[')
            {
                NestedInteger newOne = new NestedInteger();
                stk.peek().add(newOne);
                stk.push(newOne);
                start = i+1;
            }
            else if(c==']' || c==',')
            {
                if(i>start)
                {
                    int intElem = Integer.parseInt(s.substring(start, i));
                    stk.peek().add(new NestedInteger(intElem));
                }
                start = i+1;
                if(c==']')
                {
                    stk.pop();
                }
            }
        }
        return res;
    }
}
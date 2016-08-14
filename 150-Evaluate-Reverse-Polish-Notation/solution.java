public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                stack.push(stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("-"))
            {
                stack.push(-stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("*"))
            {
                stack.push(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/"))
            {
                // int n1=stack.pop(), n2=stack.pop();
                // stack.push(n2/n1);   
                stack.push(1/stack.pop()*stack.pop());  //使用这种方法会出现／0 的情况
            }
            else
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0)
            return false;
        char[] splitA = preorder.split(",");
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<splitA.length; i++)
        {
            char c = splitA[i];
            while(c=='#' && !stack.isEmpty() && c==stack.peek())
            {
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(c);
        }
        return stack.size()==1 && stack.peek()=='#';
    }
}
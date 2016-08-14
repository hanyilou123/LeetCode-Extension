public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0)
            return false;
        String[] splitA = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<splitA.length; i++)
        {
            String str = splitA[i];
            while(str.equals("#") && !stack.isEmpty() && str.equals(stack.peek()))
            {
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
}
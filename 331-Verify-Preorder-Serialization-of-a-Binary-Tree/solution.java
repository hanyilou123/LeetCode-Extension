public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0)
            return false;
        String[] splitA = preorder.split(",");
        int diff = 1;
        for(int i=0; i<splitA.length; i++)
        {
            if(--diff<0)
                return false;
            if(!splitA[i].equals("#"))
                diff +=2;
        }
        return diff==0;
    }
}
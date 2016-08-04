public class Solution {
    public String countAndSay(int n) {
        StringBuilder oldString = new StringBuilder("1");
        while(n>1)
        {
            StringBuilder sb = new StringBuilder();
            char[] oldArray = oldString.toString().toCharArray();
            for(int i=0; i<oldArray.length; i++)
            {
                int count=1;
                while(i+1<oldArray.length && oldArray[i]==oldArray[i+1])
                {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count)+String.valueOf(oldArray[i]));
            }
            oldString = sb;
            n--;
        }
        return oldString.toString();
    }
}
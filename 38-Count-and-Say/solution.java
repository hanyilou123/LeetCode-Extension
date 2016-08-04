public class Solution {
    public String countAndSay(int n) {
        StringBuilder oldString = new StringBuilder("1");
        while(n>1)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<oldString.length(); i++)
            {
                int count=1;
                while(i+1<oldString.length() && oldString.charAt(i)==oldString.charAt(i+1))
                {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count)+String.valueOf(oldString.charAt(i)));
            }
            oldString = sb;
            n--;
        }
        return oldString.toString();
    }
}
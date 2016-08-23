public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int n=words.length;
        int i=0;
        while(i<n)
        {
            int len = words[i].length();
            int j=i+1;
            while(j<n && len+1+words[j].length()<=maxWidth)
            {
                len = len+1+words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder(words[i]);
            if(j==n)
            {
                for(int k=i+1; k<n; k++)
                {
                    line.append(" ").append(words[k]);
                }
                while(line.length()<maxWidth)
                {
                    line.append(" ");
                }
            }
            else
            {
                int extraWhite = maxWidth-len;
                int count = j-i-1;
                
                if(count==0)
                {
                    while(line.length()<maxWidth)
                    {
                        line.append(" ");
                    }
                }
                else{
                    for(int k=i+1; k<j; k++)
                    {
                        line.append(" ");
                        for(int l=0; l<extraWhite/count; l++)
                        {
                            line.append(" ");
                        }
                        if(k-i<=(extraWhite%count))
                        {
                            line.append(" ");
                        }
                        line.append(words[k]);
                    }
                }
            }
            res.add(line);
            i=j;
        }
        return res;
    }
}
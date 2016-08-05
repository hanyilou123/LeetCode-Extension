public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words==null || words.length==0)
            return res;
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0; i<words.length; i++)
        {
            if(words[i].length()+sb.length()<=maxWidth)
            {
                sb.append(words[i]+" ");
                count++;
            }
            else{
                int diff = maxWidth-(sb.toString().length() - count);
                int eve = diff/(count-1);
                int more = diff-eve*(count-1);
                String eveStr="";
                while(eve>0)
                {
                    eveStr+=" ";
                    eve--;
                }
                String[] temp = sb.toString().trim().split(" ");
                StringBuilder row = new StringBuilder();
                int j =0;
                for(j=0; j<more; j++)
                {
                    row.append(temp[j]+eveStr+" ");
                }
                for(;j<temp.length-1; j++)
                {
                    row.append(temp[j]+eveStr);
                }
                row.append(temp[j]);
                res.add(row.toString());
            }
        }
        return res;
    }
}
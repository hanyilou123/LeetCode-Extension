public class Solution {
    public String reverseVowels(String s) {
        char[] toArray = s.toCharArray();
        String model = "aeiouAEIOU";
        int i=0, j=toArray.length-1;
        while(i<j)
        {
            while(i<j && !model.contains(toArray[i]+""))
                i++;
            while(i<j && !model.contains(toArray[j]+""))
                j--;
            char temp = toArray[i];
            toArray[i] = toArray[j];
            toArray[j] = temp;
            
            i++;
            j--;
        }
        return new String(toArray);
    }
}
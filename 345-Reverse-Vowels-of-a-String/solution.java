public class Solution {
    public String reverseVowels(String s) {
        char[] toArray = s.toCharArray();
        //String model = "aeiouAEIOU";
        Set<Character> model = new HashSet<Character>();
        model.add('a');model.add('e');model.add('i');model.add('o');model.add('u');
        model.add('A');model.add('E');model.add('I');model.add('O');model.add('U');
        int i=0, j=toArray.length-1;
        while(i<j)
        {
            while(i<j && !model.contains(toArray[i]))
                i++;
            while(i<j && !model.contains(toArray[j]))
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
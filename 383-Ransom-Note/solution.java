public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(int i=0; i<magazine.length(); i++)
        {
            int idx1 = magazine.charAt(i)-'a';
            letters[idx1]++;
        }
        for(int i=0; i<ransomNote.length(); i++)
        {
            int idx2 = ransomNote.charAt(i)-'a';
            if(--letters[idx2]<0)
                return false;
        }
        return true;
    }
}
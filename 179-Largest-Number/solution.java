public class Solution {
    public class compStrRev implements Comparator<String>{
        public int compare(String a, String b){
            String s1 = a+b;
            String s2 = b+a;
            return s2.compareTo(s1);
        }
    }
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return "";
        int len = nums.length;
        String[] toStr = new String[len];
        for(int i=0; i<len; i++)
        {
            toStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(toStr, new compStrRev());
        if(toStr[0].charAt(0)=='0')
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str: toStr)
        {
            sb.append(str);
        }
        return sb.toString();
    }
}
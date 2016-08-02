public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int aa=0, bb=0, cc=0, dd=0;
        int dup=0, result=0;
        aa=Math.max(A, E);
        bb=Math.max(B, F);
        cc=Math.min(C, G);
        dd=Math.min(D, H);
        if(aa>=cc || bb>dd)
            dup=0;
        else
            dup=(cc-aa)*(dd-bb);
        result = (C-A)*(D-B) + (G-E)*(H-F) - dup;
        return result;
    }
}
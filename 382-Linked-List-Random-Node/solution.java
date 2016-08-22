/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode head = null;
    Random rd;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        head = head;
        rd = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        ListNode res = null;
        for(int i=1; cur!=null; i++)
        {
            if(rd.nextInt(i)==0)
            {
                res = cur;
            }
            cur=cur.next;
        }
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
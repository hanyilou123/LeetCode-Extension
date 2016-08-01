/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null) //奇数
        {
            slow = reverse(slow.next);
        }
        else   //偶数
        {
            slow = reverse(slow);
        }
        fast = head;
        while(slow!=null)
        {
            if(slow.val!=fast.val)
                return false;
        }
        return true;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode pre = null;
        if(head!=null)
        {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}